package com.luketebo.service.impl;

import com.luketebo.dao.Cla;
import com.luketebo.doamin.Classes;
import com.luketebo.service.claSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class claSerImpl implements claSer {
    @Autowired
    private Cla cla;

    @Override
    public List<Classes> findAll() {
        return cla.selectList(null) ;
    }
}
