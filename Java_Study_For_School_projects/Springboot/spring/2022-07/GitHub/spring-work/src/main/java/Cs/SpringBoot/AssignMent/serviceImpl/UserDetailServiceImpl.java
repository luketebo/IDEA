package Cs.SpringBoot.AssignMent.serviceImpl;

import Cs.SpringBoot.AssignMent.entity.Account;
import Cs.SpringBoot.AssignMent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
    @Autowired
    private AccountService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userService.getCustomer(username);
        List<Account> auths = userService.getCustomerAuthority(username);
        List<SimpleGrantedAuthority> list = auths.stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList());
        if(account != null) {
            UserDetails userDetails = new User(account.getUsername(), account.getPassword(), list);
            return userDetails;
        }else {
            throw new UsernameNotFoundException("找不到用户");
        }
    }
}
