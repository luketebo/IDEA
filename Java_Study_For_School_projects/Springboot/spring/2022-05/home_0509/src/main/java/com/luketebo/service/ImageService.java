package com.luketebo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luketebo.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService extends IService<Image> {


    String uploadFile(MultipartFile file, MultipartFile image, String title) throws Exception;

    List<Image> getAllImage();
}
