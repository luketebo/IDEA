package com.luketebo.service.impl;

import com.luketebo.entity.FileInformation;
import com.luketebo.service.FileService;
import com.luketebo.mapper.FileMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER= LoggerFactory.getLogger(FileService.class);

    @Autowired
    FileMapper fileMapper;



    @Override
    public List<FileInformation> getAllFile() {
        return fileMapper.findAllFile();
    }

    @Override
    public String uploadFile(MultipartFile file, MultipartFile image, String title) throws Exception {
        String os = System.getProperty("os.name");
        File imagePath;  //封面图片存放地址
        File fileRealPath;   //文件存放地址
        if (os.toLowerCase().startsWith("win")) {  //windows系统
            String path = System.getProperty("user.dir");  //获取项目相对路径
            fileRealPath = new File(path+"/src//main/resources/file");
            imagePath = new File(path+"/src//main/resources/static/images");
        }else{//linux系统
            //获取根目录
            //如果是在本地windows环境下，目录为项目的target\classes下
            //如果是linux环境下，目录为jar包同级目录
            File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!rootPath.exists()){
                rootPath = new File("");
            }
            fileRealPath = new File(rootPath.getAbsolutePath()+"/file/");
            imagePath = new File(rootPath.getAbsolutePath()+"/images");
        }
        System.out.println(fileRealPath);
        System.out.println(imagePath);
        //判断文件夹是否存在
        if(!fileRealPath.exists()){
            //不存在，创建
            fileRealPath.mkdirs();
        }
        if(!imagePath.exists()){
            //不存在，创建
            imagePath.mkdirs();
        }
        //获取文件名称
        String fileName = file.getOriginalFilename();
        String imageName = image.getOriginalFilename();
        //创建文件存放地址
        File resultPath = new File(fileRealPath+"/"+fileName);
        if (resultPath.exists()){
            LOGGER.warn("文件已经存在！");
            return "false！";
        }
        //创建图片存放地址
        File imageResultPath = new File(imagePath+"/"+imageName);
        if(imageResultPath.exists()){
            LOGGER.warn("图片已经存在！");
            return "false！";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        file.transferTo(resultPath);
        image.transferTo(imageResultPath);
        fileMapper.insert(title, sdf.format(new Date()), imageName, fileName);
        System.out.println("absolutePath:"+fileRealPath.getCanonicalPath());
        System.out.println("resultPath:"+resultPath.getCanonicalPath());
        System.out.println("imageResultPath:"+imageResultPath.getCanonicalPath());
        return "true！";
    }
}

