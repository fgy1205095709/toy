package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyOrderMapper;
import com.admin.admin.pojo.ToyOrder;
import com.admin.admin.service.ToyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-18 21:17
 */
@Service
public class ToyOrderServiceimpl implements ToyOrderService {
    @Autowired
    private ToyOrderMapper toyOrderMapper;


    @Override
    public List<ToyOrder> selectByExample() {
        return toyOrderMapper.selectByExample();
    }

    @Override
    public void updatecheck(ToyOrder toyOrder) {
        toyOrderMapper.updateByPrimaryKey(toyOrder);
    }

    @Override
    public ToyOrder selectone(Integer oId) {
        return toyOrderMapper.selectByPrimaryKey(oId);
    }
}
