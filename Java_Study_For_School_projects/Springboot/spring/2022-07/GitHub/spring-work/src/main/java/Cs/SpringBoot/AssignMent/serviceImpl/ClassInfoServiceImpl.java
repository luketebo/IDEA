package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.ClassInfo;
import Cs.SpringBoot.AssignMent.mapper.ClassInfoMapper;
import Cs.SpringBoot.AssignMent.service.ClassInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:32
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo> implements ClassInfoService {

    @Autowired
    private ClassInfoMapper classInfoMapper;
    @Override
    public int UpdateClass(int clas, int id) {
        return classInfoMapper.UpdateClass(clas,id);
    }

    @Override
    public int Delete(int id) {
        return classInfoMapper.Delete(id);
    }
}
