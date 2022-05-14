package com.luketebo.controller;

import com.luketebo.entity.FileInformation;
import com.luketebo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class FileController {
    private static final Logger LOGGER= LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;


    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file,@RequestParam("fileImage")MultipartFile fileImage,@RequestParam("title")String title){
        if(file.isEmpty()){
            LOGGER.error("上传失败，请选择文件！");
            return "redirect:/getAllFile";
        }
        try {
            String result = fileService.uploadFile(file,fileImage,title);
            LOGGER.info(result);
            return "redirect:/getAllFile";
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("文件上传失败！");
            return "redirect:/getAllFile";
        }
    }


    @RequestMapping("/getAllFile")
    public String getAllFile(HttpServletRequest request, Model model){
        List<FileInformation> allFile = fileService.getAllFile();
        request.setAttribute("fileList", allFile);
        model.addAttribute("fileList", allFile);
        return "fileDownload";
    }
}
