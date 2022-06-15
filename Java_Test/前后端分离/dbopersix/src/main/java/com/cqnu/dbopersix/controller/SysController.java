package com.cqnu.dbopersix.controller;

import com.cqnu.dbopersix.entity.ResultData;
import com.cqnu.dbopersix.entity.User;
import com.cqnu.dbopersix.service.CheckLogin;
import com.cqnu.dbopersix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@ResponseBody
public class SysController {

//    public ResultData loginController(User user){
//
//    }
    @Autowired
    private UserService userService;

    @Autowired
    private ResultData resultData;

    @Autowired
    private CheckLogin checkLogin;

    @RequestMapping(value="/butRegContrller.html", method = RequestMethod.POST)
    public ResultData butRegController(@RequestBody User user){
         //校验
        if("".equals(user.getUsername())||user.getUsername()==null){
            resultData.flag="usernameIsEmpty";
            resultData.data=null;
            return resultData;
        }
        if("".equals(user.getPwd())||user.getPwd()==null){
            resultData.flag="pwdIsEmpty";
            resultData.data=null;
            return resultData;
        }
        // 调用Service方法，返回结果
        resultData=userService.regService(user);
        return resultData;
   }

    @RequestMapping(value="/menuUpdatePwdContrller.html", method = RequestMethod.POST)
   public ResultData menuUpdatePwd(){
        // check是否登录
        return checkLogin.checkLogin();
   }

    @RequestMapping(value="/butUpdatePwdContrller.html", method = RequestMethod.POST)
    public ResultData butUpdatePwd(@RequestBody User user){
        // check是否登录
        ResultData resultData1=checkLogin.checkLogin();
        if(!"success".equals(resultData1.flag)){
            return resultData1;
        }
        //校验
        if("".equals(user.getUsername())||user.getUsername()==null){
            resultData.flag="usernameIsEmpty";
            resultData.data=null;
            return resultData;
        }
        if("".equals(user.getPwd())||user.getPwd()==null){
            resultData.flag="pwdIsEmpty";
            resultData.data=null;
            return resultData;
        }

        // 调用Service方法，返回结果
        resultData=userService.regService(user);
        return resultData;
    }
}
