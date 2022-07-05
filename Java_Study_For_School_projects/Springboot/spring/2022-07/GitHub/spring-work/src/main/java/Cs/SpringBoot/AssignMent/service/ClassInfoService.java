package Cs.SpringBoot.AssignMent.service;

import Cs.SpringBoot.AssignMent.entity.ClassInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 班级表 服务类
 * </p>
 *
 * @author Dog
 * @since 2022-06-12 09:06:32
 */
public interface ClassInfoService extends IService<ClassInfo> {
    int UpdateClass(int clas,int id);
    int Delete(int id);
}
