package com.admin.admin.mapper;


import com.admin.admin.pojo.ToyNeed;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToyNeedMapper {
    List<ToyNeed> selectAll();
    void deleteByPrimaryKey(Integer nId);

    int count();

    void updateByPrimaryKey(ToyNeed toyNeed);
}