package Cs.SpringBoot.AssignMent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher_info")
public class TeacherInfo {
    @ApiModelProperty("Primary Key")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("class_id")
    private Integer classId;
    @TableField("post")
    private String post; // 职称
    @TableField("hobby")
    private String hobby; // 爱好
    @TableField("photo")
    private String photo;
}
