package com.cqnu.dbopersix.serviceimpl;

import com.cqnu.dbopersix.entity.ResultData;
import com.cqnu.dbopersix.service.CheckLogin;
import com.cqnu.dbopersix.util.OperSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckLoginImpl implements CheckLogin {
    @Autowired
    private ResultData resultData;
    @Override
    public ResultData checkLogin() {
        String flag=(String)(OperSession.getSession().getAttribute("loginFlag"));
        if(!"success".equals(flag)){
            resultData.flag="notLogin";
            resultData.data=null;
            return resultData;
        }
        resultData.flag="success";
        resultData.data=null;
        return resultData;
    }

}
