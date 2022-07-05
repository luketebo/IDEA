package Cs.SpringBoot.AssignMent.mapper;

import Cs.SpringBoot.AssignMent.entity.ClassInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 班级表 Mapper 接口
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 08:57:16
 */
@Mapper
public interface ClassMapper extends BaseMapper<ClassInfo> {

}
