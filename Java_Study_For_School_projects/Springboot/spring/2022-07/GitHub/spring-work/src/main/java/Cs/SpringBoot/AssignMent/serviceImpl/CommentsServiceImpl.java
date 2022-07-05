package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.Comments;
import Cs.SpringBoot.AssignMent.mapper.CommentsMapper;
import Cs.SpringBoot.AssignMent.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:33
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
