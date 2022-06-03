package com.example.safe.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.safe.Model.Account;
import com.example.safe.Model.Authority;

import java.util.List;

public interface AccountService extends IService<Account> {
    public Account getCustomer(String username);
    public List<Authority> getCustomerAuthority(String username);
}
