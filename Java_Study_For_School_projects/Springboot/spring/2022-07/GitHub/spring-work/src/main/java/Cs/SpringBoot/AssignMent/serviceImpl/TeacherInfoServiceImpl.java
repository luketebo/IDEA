package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.TeacherInfo;
import Cs.SpringBoot.AssignMent.mapper.TeacherInfoMapper;
import Cs.SpringBoot.AssignMent.service.TeacherInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoServiceImpl extends ServiceImpl<TeacherInfoMapper, TeacherInfo> implements TeacherInfoService {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Override
    public TeacherInfo getOne(int id) {
        return teacherInfoMapper.selectById(id);
    }

}
