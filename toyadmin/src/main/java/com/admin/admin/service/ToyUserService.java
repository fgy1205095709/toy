package com.admin.admin.service;

import com.admin.admin.pojo.ToyUser;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-12 14:54
 */
public interface ToyUserService {
    void deleteByPrimaryKey(Integer uId);
    void insert(ToyUser record);
    List<ToyUser> selectAll();
    int countAll();
    ToyUser selectByPrimaryKey(Integer uId);
    void updateByPrimaryKey(ToyUser record);
}
