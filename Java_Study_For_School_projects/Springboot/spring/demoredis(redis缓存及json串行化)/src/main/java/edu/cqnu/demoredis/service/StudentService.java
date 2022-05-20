package edu.cqnu.demoredis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqnu.demoredis.model.Student;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wp
 * @since 2022-04-12
 */
public interface StudentService extends IService<Student> {
    Student getOne(Integer id);
    Student myUpdate(Integer id);
    int myDelete(Integer id);
}
