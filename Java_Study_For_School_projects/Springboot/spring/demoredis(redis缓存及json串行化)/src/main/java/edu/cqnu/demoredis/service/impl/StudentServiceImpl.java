package edu.cqnu.demoredis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqnu.demoredis.mapper.StudentMapper;
import edu.cqnu.demoredis.model.Student;
import edu.cqnu.demoredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
/*    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Student getOne(Integer id) {
        Object obj = redisTemplate.opsForValue().get("stu_" + id.toString());
        if (obj != null) {
            return (Student) obj;
        } else {
            StudentMapper baseMapper = this.getBaseMapper();
            Student stu = baseMapper.selectById(id);
            redisTemplate.opsForValue().set("stu_" + id.toString(), stu, 1, TimeUnit.HOURS);
            return stu;
        }
    }

    @Override
    public Student myUpdate(Integer id) {
        return null;
    }

    @Override
    public boolean updateById(Student stu) {
        boolean flag = super.updateById(stu);
        redisTemplate.opsForValue().set("stu_" + stu.getId(), stu);
        return flag;
    }

    @Override
    public int myDelete(Integer id) {
        int flag = this.baseMapper.deleteById(id);
        redisTemplate.delete("stu_"+id.toString());
        return flag;
    }*/
    @Override
    @Cacheable(cacheNames = "student")
    public Student getOne(Integer id) {
        StudentMapper studentMapper = this.getBaseMapper();
        Student student = studentMapper.selectById(id);
        return student;
    }

    @Override
    @CachePut(cacheNames = "student",key="#id")
    public Student myUpdate(Integer id) {
        Student stu = this.getOne(id);
        stu.setName("zhangsan");
        stu.setScore(9999);
        this.baseMapper.updateById(stu);
        return stu;
    }

    @Override
    @CacheEvict(cacheNames = "student",key="#id")
    public int myDelete(Integer id) {
        int flag = this.baseMapper.deleteById(id);
        return flag;
    }

    @Override
    public List<Student> list() {
        return super.list();
    }
}
