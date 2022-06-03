package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.Account;
import com.luketebo.entity.Authority;
import com.luketebo.mapper.AccountMapper;
import com.luketebo.mapper.AuthorityMapper;
import com.luketebo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
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
