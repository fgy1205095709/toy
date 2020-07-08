package com.admin.admin.service;

import com.admin.admin.pojo.ToyDesigner;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-16 19:52
 */
public interface ToyDesignerService {
    List<ToyDesigner> selectAll();
    int count();
    void updateByGrade(ToyDesigner toyDesigner);
}
