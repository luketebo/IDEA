package Cs.SpringBoot.AssignMent.controller;

import Cs.SpringBoot.AssignMent.entity.Account;
import Cs.SpringBoot.AssignMent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;

@Controller
public class AccountController {
@Autowired
private AccountService accountService;
    //登录：
    @GetMapping("/login")
    public String login(){
        return "Login/Login";
    }

    @GetMapping("/middle")
    public String middle(){
        return "Login/Middle";
    }
    //注册：
    @GetMapping("/zhuCe")
    public String zhuCe(){
        return "Login/ZhuCe";
    }

    @GetMapping("/end")
    public String end(HttpServletRequest req){
        // 获取网页输入的username、password、authority
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String auth = req.getParameter("authority");
        // 创建一个新user
        Account user = new Account();
        // 密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        // 给新对象setUsername和Password
        user.setUsername(username);
        user.setPassword(encode);
//        user.setPassword(encode);
//        user.setUsername(username);
        // 判断身份码分别setAuthority
        if(Objects.equals(auth, "student")){
            user.setAuthority("ROLE_student");}
        else if(Objects.equals(auth, "teacher")) {
            user.setAuthority("ROLE_teacher");
        } else if(Objects.equals(auth, "adminer")) {
            user.setAuthority("ROLE_adminer");
        }
        // 将user注册到数据库
        boolean flag = accountService.zhuCe(user);
        // 根据注册的返回值跳转到不同页面
        if(flag){
            return "Login/End1";
        }else{
            return "Login/End2";
        }
    }

    // 判断登录账号teacher、student、adminer，跳转到不同页面
    @RequestMapping(value="/dispatch", method = RequestMethod.GET)
    public View dispatch(HttpServletRequest req) {
        // 获取当前页面的名字
        String path = req.getContextPath() ;
        System.out.println("path:"+path);
        // getSchema()可以返回当前页面使用的协议,http或是https
        // getServerName()可以返回当前页面所在的服务器的名字localhost
        // getServerPort()可以返回当前页面所在的服务器使用的端口号;
        // basePath="https://localhost:8081/
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
        System.out.println("basePath:"+basePath);
        // authorityListToSet()将对象的数组转换为Set
        // SecurityContextHolder用于存储安全上下文(security context)的信息。
        // getContext()获取到当前对象的上下文
        // getAuthentication().getAuthorities()获取Authoritues
        Set<String> roles = AuthorityUtils.authorityListToSet(
                SecurityContextHolder.getContext().getAuthentication().getAuthorities()
        );
        // 如果roles里面包含"ROLE_student"则return "student";
        if (roles.contains("ROLE_student")) {
            return new RedirectView(basePath + "student");
        }
        // 如果roles里面包含"ROLE_teacher"则return "Teacher/teacher";
        else if(roles.contains("ROLE_teacher")) {
            return new RedirectView(basePath + "teacher");
        }
        // 如果roles里面包含"ROLE_adminer"则return "admin/admin_student";

        else if(roles.contains("ROLE_adminer")) {
            return new RedirectView(basePath + "AssignMent/teacher/admin");
        } else {
            return null;
        }
    }

}