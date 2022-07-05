package Cs.SpringBoot.AssignMent.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 作业表
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:32
 */
@Data
@Getter
@Setter
@ToString
@TableName("assignment")
@ApiModel(value = "Assignment对象", description = "作业表")
public class Assignment {

    @ApiModelProperty("Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("创建人")
    @TableField("create_id")
    private String createId;

    @ApiModelProperty("作业内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("截至时间")
    @TableField("dead_line")
    private Date deadLine;

    @ApiModelProperty("班级id")
    @TableField("class_id")
    private String classId;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

}
