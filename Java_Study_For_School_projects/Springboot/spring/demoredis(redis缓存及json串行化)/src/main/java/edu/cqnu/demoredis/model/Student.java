package edu.cqnu.demoredis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private double score;
    private Date enrollDate;
    private String photo;
}
