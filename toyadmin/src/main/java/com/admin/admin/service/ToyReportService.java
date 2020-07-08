package com.admin.admin.service;

import com.admin.admin.pojo.ToyReport;
import com.admin.admin.pojo.ToyReportall;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-13 16:21
 */
public interface ToyReportService {

    void deleteByPrimaryKey(Integer reId);
    void insert(ToyReport record);
    List<ToyReportall> selectAll();
    int countall();
    ToyReportall selectByPrimaryKey(Integer reId);
    void updateByPrimaryKey(ToyReport record);
    int countif();
}
