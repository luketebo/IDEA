package com.luketebo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.luketebo.entity.People;

public interface PeopleService extends IService<People> {

    People getOne(Integer id);

}
