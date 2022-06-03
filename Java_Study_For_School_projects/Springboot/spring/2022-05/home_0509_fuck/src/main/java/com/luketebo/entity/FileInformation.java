package com.luketebo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class FileInformation {


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String uploadDate;

    private String imageName;

    private String fileName;
}
