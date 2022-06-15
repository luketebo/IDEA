package com.cqnu.dbopersix.serviceimpl;

import com.cqnu.dbopersix.entity.ResultData;
import com.cqnu.dbopersix.entity.User;
import com.cqnu.dbopersix.mapper.UserMapper;
import com.cqnu.dbopersix.service.UserService;
import com.cqnu.dbopersix.util.OperSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ResultData resultData;
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultData regService(User user) {
        // 已经被注册
        User user1=userMapper.findByID(user);
        if (user1!=null){
            resultData.flag="registered";
            resultData.data=null;
            return resultData;
        }

        // 没有被注册
        // 写入数据库
        try{
            userMapper.insert(user);
        }
        catch(Exception ee){
            resultData.flag="insertError";
            resultData.data=null;
            return resultData;
        }

        // 读出写入数据，返回注册用户信息
        user1=userMapper.findByID(user);
        resultData.flag="success";
        resultData.data=user1;
        return resultData;
    }

    @Override
    public ResultData loginService(User user) {
        // 数据库中找用户
        // 已经被注册
        User user1=userMapper.findByID(user);

        // 没有找到
        if (user1==null){
            resultData.flag="noReg";
            resultData.data=null;
            return resultData;
        }
        // 找到了，比对密码
        if(!user.getPwd().equals(user1.getPwd())){  // 密码不对
            resultData.flag="pwdError";
            resultData.data=null;
            return resultData;
        }
        // 应该正确的登录
        // 写session
        OperSession.getSession().setAttribute("loginFlag","success");
        resultData.flag="success";
        resultData.data=null;
        return resultData;
    }

    @Override
    public ResultData updatePWDService(User user) {
        User user1=userMapper.findByID(user);
        // 没有找到
        if (user1==null){
            resultData.flag="noReg";
            resultData.data=null;
            return resultData;
        }
        int num =userMapper.update(user);
        if(num!=1){//没有更新
            resultData.flag="updateError";
            resultData.data=null;
            return resultData;
        }
        //更新
        resultData.flag="success";
        user1=userMapper.findByID(user);
        resultData.data=user1;
        return resultData;
    }


}
