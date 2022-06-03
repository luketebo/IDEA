package com.luketebo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    @TableId(type= IdType.AUTO)
    private int id;
    private String name;
    private Double score;
    private Date enrollDate;
    private String photo;

}
