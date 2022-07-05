package Cs.SpringBoot.AssignMent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 作业提交
 *
 * @author 13947
 * @date 17:35
 */
@Data
@TableName("work")
public class Work {
    @ApiModelProperty("Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 作业
     */
    private Integer assignmentId;


    /**
     * 学生名称
     */
    private String studentName;

    /**
     * 提交的答案
     */
    private String answer;

}
