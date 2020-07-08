package com.admin.admin.service;

import com.admin.admin.pojo.ToyClassification;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-10 19:15
 */
public interface ToyClassificationService {
    List<ToyClassification> selectAll();
    void deleteByPrimaryKey(Integer cId);
    void insert(ToyClassification record);
    ToyClassification selectByPrimaryKey(Integer cId);
    void updateByPrimaryKey(ToyClassification record);
    int countAll();
    int countnet();
}
