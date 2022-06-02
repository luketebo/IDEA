package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.Account;
import com.luketebo.mapper.AccountMapper;
import com.luketebo.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
