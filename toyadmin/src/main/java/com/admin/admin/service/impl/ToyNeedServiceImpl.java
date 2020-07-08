package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyNeedMapper;
import com.admin.admin.pojo.ToyNeed;
import com.admin.admin.service.ToyNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-17 15:11
 */
@Service
public class ToyNeedServiceImpl implements ToyNeedService {
    @Autowired
    private ToyNeedMapper toyNeedMapper;
    @Override
    public List<ToyNeed> selectAll() {
        return toyNeedMapper.selectAll();
    }

    @Override
    public int count() {
        return toyNeedMapper.count();
    }

    @Override
    public void deleteByPrimaryKey(Integer nId) {
        toyNeedMapper.deleteByPrimaryKey(nId);
    }

    @Override
    public void update(ToyNeed toyNeed) {
        toyNeed.setnState(1);
        if (toyNeed.getnIf()==2)
            toyNeed.setnState(4);
        System.out.println(toyNeed.getnIf());
        toyNeedMapper.updateByPrimaryKey(toyNeed);
    }
}
