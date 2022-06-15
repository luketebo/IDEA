package com.cqnu.dbopersix;

import com.cqnu.dbopersix.entity.ResultData;
import com.cqnu.dbopersix.entity.User;
import com.cqnu.dbopersix.mapper.UserMapper;
import com.cqnu.dbopersix.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class DbopersixApplicationTests {
        @Autowired
        private User user;
        @Autowired
        private UserService userService;
         @Autowired
        private ResultData resultData;

         @Autowired
         private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testReg(){
        // 定义controller方法的参数
//        user.setUsername(null);
        user.setUsername("zhangsansan1");
//        user.setPwd("");
        user.setPwd("123");

        //校验
        if("".equals(user.getUsername())||user.getUsername()==null){
            resultData.flag="usernameIsEmpty";
            resultData.data=null;
            System.out.println(resultData.flag);
            return;
        }
        if("".equals(user.getPwd())||user.getPwd()==null){
            resultData.flag="pwdIsEmpty";
            resultData.data=null;
            System.out.println(resultData.flag);
            return;
        }
        // 调用Service方法，返回结果
        resultData=userService.regService(user);
        System.out.println(resultData.flag);
    }

    @Test
    void testInsert(){
        user.setUsername("zhangsansan");
        user.setPwd("123");
        userMapper.insert(user);
        System.out.println(123);

    }

}
