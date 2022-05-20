package edu.cqnu.demostudent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqnu.demostudent.mapper.StudentMapper;
import edu.cqnu.demostudent.model.Student;
import edu.cqnu.demostudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wp
 * @since 2022-04-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student getOne(Integer id) {
        StudentMapper studentMapper = this.getBaseMapper();
        Student student = studentMapper.selectById(id);
        return student;
    }
}
