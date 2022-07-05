package Cs.SpringBoot.AssignMent.service;

import Cs.SpringBoot.AssignMent.entity.TeacherInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TeacherInfoService extends IService<TeacherInfo> {
    TeacherInfo getOne(int id);
}
