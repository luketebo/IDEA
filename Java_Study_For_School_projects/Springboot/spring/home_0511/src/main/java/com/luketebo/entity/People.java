package com.luketebo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class People {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Double score;
    private Date enrollDate;
    private String photo;
}
