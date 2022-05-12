package com.luketebo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luketebo.entity.People;
import com.luketebo.mapper.PeopleMapper;
import com.luketebo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(cacheNames = "people") // 缓存
    public People getOne(Integer id) {
        return this.getBaseMapper().selectById(id);
    }
    @Override
    @CachePut(cacheNames = "people", key = "#id") // 更新
    public People myUpdate(People people) {
        this.baseMapper.updateById(people);
        return people;
    }
    @Override
    @CacheEvict(cacheNames = "people", key = "#id") // 清除缓存
    public int myDelete(Integer id) {
        return this.baseMapper.deleteById(id);
    }

}
