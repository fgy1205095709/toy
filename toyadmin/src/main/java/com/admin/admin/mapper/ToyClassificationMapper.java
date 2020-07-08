package com.admin.admin.mapper;

import com.admin.admin.pojo.ToyClassification;
import com.admin.admin.pojo.ToyCreateidea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ToyClassificationMapper {
    List<ToyClassification> selectAll();
    int countAll();
    int countnet();
    int deleteByPrimaryKey(Integer cId);
    int insert(ToyClassification record);
    ToyClassification selectByPrimaryKey(Integer cId);
    int updateByPrimaryKey(ToyClassification record);

}