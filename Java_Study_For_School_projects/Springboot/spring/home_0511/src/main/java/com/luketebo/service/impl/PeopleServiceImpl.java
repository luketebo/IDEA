package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.People;
import com.luketebo.mapper.PeopleMapper;
import com.luketebo.service.PeopleService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {

    @Override
    @Cacheable(cacheNames = "people", key = "#id") // 缓存
    public People getOne(Integer id) {
        return this.getBaseMapper().selectById(id);
    }
}
