package com.luketebo.service.impl;

import com.luketebo.entity.Account;
import com.luketebo.entity.Authority;
import com.luketebo.service.AccountService;
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
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountService.getCustomer(username);
        List<Authority> auths = accountService.getCustomerAuthority(username);
        List<SimpleGrantedAuthority> list = auths.stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList());
        if(user != null) {
            UserDetails userDetails = new User(user.getUsername(), user.getPassword(), list);
            return userDetails;
        }else {
            throw new UsernameNotFoundException("找不到用户");
        }
    }

}
