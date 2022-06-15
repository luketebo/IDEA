package com.cqnu.dbopersix.service;

import com.cqnu.dbopersix.entity.ResultData;
import com.cqnu.dbopersix.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
//    public ResultData loginService(User user);
    public ResultData regService(User user);

    public ResultData loginService(User user);

    public ResultData updatePWDService(User user);
}
