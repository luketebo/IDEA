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
@TableName("student_info")
public class StudentInfo {
    @ApiModelProperty("Primary Key")
    @TableId(value="id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("class_id")
    private Integer classId;
    @TableField("c_score")
    private Integer cScore;
    @TableField("web_score")
    private Integer webScore;
    @TableField("java_score")
    private Integer javaScore;
//    private String photo;
}
