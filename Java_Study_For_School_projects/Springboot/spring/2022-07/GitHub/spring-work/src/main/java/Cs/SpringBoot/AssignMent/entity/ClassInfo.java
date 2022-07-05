package Cs.SpringBoot.AssignMent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:32
 */
@Getter
@Setter
@AllArgsConstructor
@TableName("class_info")
@ApiModel(value = "ClassInfo对象", description = "班级表")
public class ClassInfo {

    @ApiModelProperty("Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("老师")
    @TableField("teacher_id")
    private Integer teacherId;

    @ApiModelProperty("接管班级")
    @TableField("class_id")
    private Integer classId;


}
