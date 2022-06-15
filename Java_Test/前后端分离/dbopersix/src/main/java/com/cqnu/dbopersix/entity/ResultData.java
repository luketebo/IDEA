package com.cqnu.dbopersix.entity;

import org.springframework.stereotype.Component;

@Component
public class ResultData {
    public String flag;
    public Object data;

    public ResultData() {}
    public ResultData(String flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
