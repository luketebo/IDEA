package com.luketebo.service;

import com.luketebo.entity.FileInformation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    String uploadFile(MultipartFile file, MultipartFile image, String title) throws Exception;

    List<FileInformation> getAllFile();
}
