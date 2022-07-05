package Cs.SpringBoot.AssignMent.service;

import Cs.SpringBoot.AssignMent.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface AccountService extends IService<Account> {
    public Account getCustomer(String username);
    public List<Account> getCustomerAuthority(String username);
    public boolean zhuCe(Account user);
}
