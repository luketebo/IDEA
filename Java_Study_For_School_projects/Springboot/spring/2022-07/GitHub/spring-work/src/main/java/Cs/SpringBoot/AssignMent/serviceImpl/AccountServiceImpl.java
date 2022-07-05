package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.Account;
import Cs.SpringBoot.AssignMent.mapper.AccountMapper;
import Cs.SpringBoot.AssignMent.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    // 引入UserMapper类
    private AccountMapper accountMapper;

    @Override
    // 通过sql语句查找到username对应的信息 ("select * from user where username=#{username}")
    public Account getCustomer(String username) {
        return accountMapper.findByUsername(username);
    }

    @Override
    // 通过sql语句查找到username对应的信息 ("select * from user where username=#{username}")
    public List<Account> getCustomerAuthority(String username) {
        return accountMapper.findAuthorityByUsername(username);
    }

    @Override
    // 通过sql语句插入user("insert into  user(username,password,authority) values(#{username},#{password},#{authority})")
    public boolean zhuCe(Account user) {
        int x = accountMapper.insertUser(user);
        return x > 0;
    }

}

