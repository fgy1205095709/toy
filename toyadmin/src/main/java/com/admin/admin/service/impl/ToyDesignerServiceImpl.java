package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyDesignerMapper;
import com.admin.admin.pojo.ToyDesigner;
import com.admin.admin.service.ToyDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-16 19:53
 */
@Service
public class ToyDesignerServiceImpl implements ToyDesignerService {
    @Autowired
    private ToyDesignerMapper toyDesignerMapper;
    @Override
    public List<ToyDesigner> selectAll() {
        List<ToyDesigner> list=toyDesignerMapper.selectAll();
        return list;
    }

    @Override
    public int count() {
        return toyDesignerMapper.selectAllcount();
    }

    @Override
    public void updateByGrade(ToyDesigner toyDesigner) {
        toyDesignerMapper.updateByGrade(toyDesigner);
    }
}
