package com.admin.admin.service;

import com.admin.admin.pojo.LayuiPageInfo;
import com.admin.admin.pojo.ToyLogWithBLOBs;

import java.util.List;
import java.util.Map;

/**
 * @anther fgy
 * @title
 * @time 2019-11-10 12:58
 */
public interface ToyLogService {

    void insert(ToyLogWithBLOBs record);

    List<ToyLogWithBLOBs> selectAll();
    int count();
    ToyLogWithBLOBs selectByPrimaryKey(Integer lId);

    LayuiPageInfo<ToyLogWithBLOBs> getList(Map<String, Object> params);

    void del(Integer id);
}
