package com.example.safe.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.safe.Mapper.AccountMapper;
import com.example.safe.Mapper.AuthorityMapper;
import com.example.safe.Model.Account;
import com.example.safe.Model.Authority;
import com.example.safe.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService{
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public Account getCustomer(String username) {
        Account user = accountMapper.findByUsername(username);
        return user;
    }

    @Override
    public List<Authority> getCustomerAuthority(String username) {
        List<Authority> auths = authorityMapper.findAuthoritiesByUsername(username);
        return auths;
    }
}
