package com.example.safe.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.safe.Model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    @Select("select * from t_user where username=#{username}")
    Account findByUsername(String username);
}
