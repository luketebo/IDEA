package Cs.SpringBoot.AssignMent.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
//        return new OrderedHiddenHttpMethodFilter();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 密码的加解密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();        //一种常用的比较安全的加密机制
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // teacher student adminer赋权限
        http.authorizeHttpRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/Login/**").permitAll()
                .antMatchers("/","/css/**","/js/**","/img/**", "/icon/**").permitAll()
                .antMatchers("/InfoGet/**", "/InfoDelete/**").permitAll()
                .antMatchers("/InfoPost/**", "/InfoPut/**").permitAll()
                .antMatchers("/detail/student/**").hasRole("student")
                .antMatchers("/teacher/**").hasRole("teacher")
                .antMatchers("/Teacher/**").hasRole("teacher")
                .antMatchers("/admin/**").hasRole("adminer")
                .anyRequest().authenticated();

        // 跳转页面
        http.formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/dispatch")
                .failureUrl("/middle");

        http.csrf().disable();

    }


}
