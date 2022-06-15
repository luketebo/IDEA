package com.cqnu.dbopersix.service;

import com.cqnu.dbopersix.entity.ResultData;
import org.springframework.stereotype.Service;

@Service
public interface CheckLogin {
    public ResultData checkLogin();
}
