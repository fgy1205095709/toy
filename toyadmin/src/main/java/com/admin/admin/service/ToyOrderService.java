package com.admin.admin.service;

import com.admin.admin.pojo.ToyOrder;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-18 21:17
 */
public interface ToyOrderService {
    List<ToyOrder> selectByExample();

    void updatecheck(ToyOrder toyOrder);

    ToyOrder selectone(Integer oId);
}
