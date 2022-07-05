package Cs.SpringBoot.AssignMent.mapper;

import Cs.SpringBoot.AssignMent.entity.ClassInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 班级表 Mapper 接口
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:32
 */
@Mapper
public interface ClassInfoMapper extends BaseMapper<ClassInfo> {
    @Update("update class_info set class_id = #{clas} where teacher_id = #{id}")
    public int UpdateClass(int clas,int id);
    @Delete("delete from class_info where teacher_id=#{id}")
    public int Delete(int id);
}
