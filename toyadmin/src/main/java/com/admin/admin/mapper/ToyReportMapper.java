package com.admin.admin.mapper;

import com.admin.admin.pojo.ToyReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ToyReportMapper {
    void deleteByPrimaryKey(Integer reId);
    void insert(ToyReport record);


    List<ToyReport> selectall();

    List<ToyReport> selectAll();
    List<ToyReport> selectuser();
    List<ToyReport> selectbuser();
    int countall();
    ToyReport selectByPrimaryKey(Integer reId);
    void updateByPrimaryKey(ToyReport record);
    int countif();
}