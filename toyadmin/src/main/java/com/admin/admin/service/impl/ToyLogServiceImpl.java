package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyLogMapper;
import com.admin.admin.pojo.LayuiPageInfo;
import com.admin.admin.pojo.ToyLogWithBLOBs;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @anther fgy
 * @title
 * @time 2019-11-10 12:58
 */
@Service
public class ToyLogServiceImpl implements ToyLogService {
    @Autowired
    private ToyLogMapper toyLogMapper;
    @Override
    public void insert(ToyLogWithBLOBs record) {
        toyLogMapper.insert(record);
    }

    @Override
    public List<ToyLogWithBLOBs> selectAll() {
        return toyLogMapper.selectByExample();
    }

    @Override
    public int count() {
        return toyLogMapper.count();
    }

    @Override
    public ToyLogWithBLOBs selectByPrimaryKey(Integer lId) {
        return toyLogMapper.selectByPrimaryKey(lId);
    }

    @Override
    public LayuiPageInfo<ToyLogWithBLOBs> getList(Map<String, Object> params) {
        CommonUtil.startPage(params);
        List<ToyLogWithBLOBs> list = toyLogMapper.selectByExample();

        return new LayuiPageInfo<>(list);
    }

    @Override
    public void del(Integer id) {

            toyLogMapper.del(id);
    }
}
