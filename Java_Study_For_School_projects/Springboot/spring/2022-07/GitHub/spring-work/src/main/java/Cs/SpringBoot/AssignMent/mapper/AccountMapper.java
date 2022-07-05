package Cs.SpringBoot.AssignMent.mapper;

import Cs.SpringBoot.AssignMent.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
// 一些sql语句
public interface AccountMapper extends BaseMapper<Account> {
    @Select("select * from user where username=#{username}")
    Account findByUsername(String username);
    @Select("select * from user where username=#{username}")
    List<Account> findAuthorityByUsername(String username);
    @Insert("insert into  user(username,password,authority) values(#{username},#{password},#{authority})")
    public int insertUser(Account user);
}
