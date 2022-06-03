package com.luketebo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    @Select("select * from s_user where username=#{username}")
    Account findByUsername(String username);
}
