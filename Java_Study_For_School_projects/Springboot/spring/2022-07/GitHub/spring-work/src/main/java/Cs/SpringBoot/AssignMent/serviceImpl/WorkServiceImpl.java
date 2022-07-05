package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.Work;
import Cs.SpringBoot.AssignMent.mapper.WorkMapper;
import Cs.SpringBoot.AssignMent.service.WorkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 提交作业 服务实现类
 * </p>
 *
 * @author 13947
 * @since 2022-06-12 09:06:33
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {

}
