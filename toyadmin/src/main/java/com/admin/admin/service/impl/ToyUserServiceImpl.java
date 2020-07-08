package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyUserMapper;
import com.admin.admin.pojo.ToyUser;
import com.admin.admin.service.ToyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-12 14:56
 */
@Service
public class ToyUserServiceImpl implements ToyUserService {
    @Autowired
    private ToyUserMapper toyUserMapper;
    @Override
    public void deleteByPrimaryKey(Integer uId) {

    }

    @Override
    public void insert(ToyUser record) {

    }

    @Override
    public List<ToyUser> selectAll() {
        List<ToyUser> list=toyUserMapper.selectAll();
        return list;
    }

    @Override
    public int countAll() {
        return toyUserMapper.countAll();
    }

    @Override
    public ToyUser selectByPrimaryKey(Integer uId) {
        ToyUser user=toyUserMapper.selectByPrimaryKey(uId);
        return user;
    }

    @Override
    public void updateByPrimaryKey(ToyUser record) {
        toyUserMapper.updateByPrimaryKey(record);
    }
}
