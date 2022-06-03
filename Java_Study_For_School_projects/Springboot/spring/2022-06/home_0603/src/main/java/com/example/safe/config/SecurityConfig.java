package com.example.safe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);基类的认证机制
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//一种常用的比较安全的加密机制
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("mike").password(encoder.encode("123456")).roles("common")
//                .and()
//                .withUser("zhangsan").password(encoder.encode("12233")).roles("common")
//                .and()
//                .withUser("lisi").password(encoder.encode("125567")).roles("common");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/student/**").hasRole("common")
                .antMatchers("/detail/teacher/**").hasRole("vip")
                .anyRequest().authenticated();

        http.formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error");

        http.rememberMe()
                .rememberMeParameter("rememberme")
                .tokenValiditySeconds(1000)
                //对Cookie信息进行持久化管理
                .tokenRepository(tokenRepository());
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jr = new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;
    }
}
