package Cs.SpringBoot.AssignMent.mapper;

import Cs.SpringBoot.AssignMent.entity.Assignment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 作业表 Mapper 接口
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 08:57:15
 */
@Mapper
public interface AssignmentMapper extends BaseMapper<Assignment> {

}
