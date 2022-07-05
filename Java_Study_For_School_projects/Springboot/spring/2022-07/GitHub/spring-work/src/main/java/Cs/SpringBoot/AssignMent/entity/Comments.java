package Cs.SpringBoot.AssignMent.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:33
 */
@Getter
@Setter
@TableName("comments")
@ApiModel(value = "Comments对象", description = "评论表")
public class Comments {

    @ApiModelProperty("Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("评论人")
    @TableField("comment_id")
    private String commentTd;

    @ApiModelProperty("评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("评论时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

}
