package com.luketebo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
@Accessors(chain = true)
public class Account {
    @TableId(type = IdType.INPUT, value = "id")
    private Integer id;
    private String username;
    private String password;
}
