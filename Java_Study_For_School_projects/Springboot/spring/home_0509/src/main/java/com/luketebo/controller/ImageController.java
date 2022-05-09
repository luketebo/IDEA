package com.luketebo.controller;

import com.luketebo.dao.ImageDao;
import com.luketebo.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageDao imageDao;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") String file) {
        LOGGER.info("uploadFile");
        return "fuck";
    }
}
