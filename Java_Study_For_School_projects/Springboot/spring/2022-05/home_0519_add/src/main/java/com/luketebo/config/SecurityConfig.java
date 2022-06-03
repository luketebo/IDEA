package com.luketebo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder ecoder = new BCryptPasswordEncoder();  // 加密机制
        // 生成内存中的用户信息
        auth.inMemoryAuthentication().passwordEncoder(ecoder)
                .withUser("luketebo").password(ecoder.encode("123456")).roles("common")
                .and()
                .withUser("mike").password(ecoder.encode("123456")).roles("common");
    }

    @Override  // 实现授权
    protected void configure(HttpSecurity http) throws Exception {

    }
}






































