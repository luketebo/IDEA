package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.Assignment;
import Cs.SpringBoot.AssignMent.mapper.AssignmentMapper;
import Cs.SpringBoot.AssignMent.service.AssignmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 作业表 服务实现类
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:32
 */
@Service
public class AssignmentServiceImpl extends ServiceImpl<AssignmentMapper, Assignment> implements AssignmentService {

}
