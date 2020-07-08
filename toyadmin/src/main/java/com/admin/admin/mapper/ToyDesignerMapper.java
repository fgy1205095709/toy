package com.admin.admin.mapper;

import com.admin.admin.pojo.ToyDesigner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ToyDesignerMapper {

    void deleteByPrimaryKey(Integer dId);

    void insert(ToyDesigner record);

    List<ToyDesigner> selectAll();
    int selectAllcount();
    ToyDesigner selectByPrimaryKey(Integer dId);

    void updateByPrimaryKey(ToyDesigner record);

    void updateByGrade(ToyDesigner record);
}