package com.admin.admin.mapper;


import com.admin.admin.pojo.ToyLogWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToyLogMapper {

    void insert(ToyLogWithBLOBs record);

    List<ToyLogWithBLOBs> selectByExample();

    ToyLogWithBLOBs selectByPrimaryKey(Integer lId);

    int count();

    void del(Integer lId);
}