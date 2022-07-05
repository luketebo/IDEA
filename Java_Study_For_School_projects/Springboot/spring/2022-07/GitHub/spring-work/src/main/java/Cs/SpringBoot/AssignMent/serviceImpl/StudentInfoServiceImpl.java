package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.StudentInfo;
import Cs.SpringBoot.AssignMent.mapper.StudentInfoMapper;
import Cs.SpringBoot.AssignMent.service.StudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {
}
