package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyClassificationMapper;
import com.admin.admin.pojo.ToyClassification;
import com.admin.admin.service.ToyClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-10 19:20
 */
@Service
public class ToyClassificationServiceImpl implements ToyClassificationService {
    @Autowired
    private ToyClassificationMapper toyClassificationMapper;
    @Override
    public List<ToyClassification> selectAll() {
        List<ToyClassification> list=toyClassificationMapper.selectAll();
        return list;
    }

    @Override
    public void deleteByPrimaryKey(Integer cId) {
        toyClassificationMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public void insert(ToyClassification record) {

    }

    @Override
    public ToyClassification selectByPrimaryKey(Integer cId) {
        return null;
    }

    @Override
    public void updateByPrimaryKey(ToyClassification record) {
        toyClassificationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int countAll() {
        int count=toyClassificationMapper.countAll();
        return count;
    }

    @Override
    public int countnet() {
        return toyClassificationMapper.countnet();
    }
}
