package com.example.safe.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.safe.Model.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {
    @Select("select a.* from t_user c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username=#{username}")
    public List<Authority> findAuthoritiesByUsername(String username);
}
