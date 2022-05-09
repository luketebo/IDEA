package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.dao.ImageDao;
import com.luketebo.entity.Image;
import com.luketebo.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ImageServiceImpl extends ServiceImpl<ImageDao, Image> implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    ImageDao imageDao;

    @Override
    public String uploadFile(MultipartFile file, MultipartFile image, String title) throws Exception {
        String os = System.getProperty("os.name");
        File imagePath;
        File fileRealPath;
        if (os.toLowerCase().startsWith("win")) {
            String path = System.getProperty("user.dir");
            fileRealPath = new File(path + "\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
            imagePath = new File(path + "\\src\\main\\resources\\static\\images\\" + image.getOriginalFilename());
        } else {
            File root = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!root.exists()) {
                root = new File("");
            }
            fileRealPath = new File(root.getAbsolutePath() + "/src/main/resources/static/images/" + file.getOriginalFilename());
            imagePath = new File(root.getAbsolutePath() + "/src/main/resources/static/images/" + image.getOriginalFilename());
        }
        if(!fileRealPath.exists()){
            fileRealPath.mkdirs();
        }
        if(!imagePath.exists()){
            imagePath.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        String imageName = image.getOriginalFilename();
        File resultFile = new File(fileRealPath + "/" + fileName);
        if(resultFile.exists()){
            LOGGER.warn("文件已存在");
            return "false!";
        }
        File imageResultPath = new File(imagePath + "/" + imageName);
        if(imageResultPath.exists()){
            LOGGER.warn("图片已存在");
            return "false!";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        file.transferTo(resultFile);
        image.transferTo(imageResultPath);
        imageDao.insert(title, simpleDateFormat.format(new Date()), imageName, fileName);
        System.out.println("absolutePath:" + resultFile.getCanonicalPath());
        System.out.println("resultFile:" + resultFile.getCanonicalPath());
        System.out.println("imageResultPath:" + imageResultPath.getCanonicalPath());
        return "true!";
    }

    @Override
    public List<Image> getAllImage() {
        return imageDao.findAllFile();
    }
}
