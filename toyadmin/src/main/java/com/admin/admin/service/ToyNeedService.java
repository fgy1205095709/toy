package com.admin.admin.service;

import com.admin.admin.pojo.ToyNeed;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-17 15:11
 */
public interface ToyNeedService {

    List<ToyNeed> selectAll();
    int count();

    void deleteByPrimaryKey(Integer nId);

    void update(ToyNeed toyNeed);
}
