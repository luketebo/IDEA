package com.luketebo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luketebo.entity.Account;
import com.luketebo.entity.Authority;

public interface AccountService extends IService<Account> {
    public Account getCustomer(String username);
    public List<Authority> getCustomerAuthority(String username);
}
