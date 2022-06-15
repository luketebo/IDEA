package com.cqnu.dbopersix.mapper;

import com.cqnu.dbopersix.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username, pwd) values(#{username}, #{pwd})")
    public int insert(User user);
    @Select("select * from user where username = #{username}")
    public User findByID(User user);
    @Update("update  user set pwd=#{pwd} where username = #{username}")
    public int update(User user);
}
