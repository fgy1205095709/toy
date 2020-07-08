package com.admin.admin.mapper;

import com.admin.admin.pojo.ToyOrder;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ToyOrderMapper {


    List<ToyOrder> selectByExample();

    ToyOrder selectByPrimaryKey(Integer oId);

    int updateByPrimaryKey(ToyOrder record);
}