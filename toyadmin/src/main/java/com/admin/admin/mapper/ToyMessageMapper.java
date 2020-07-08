package com.admin.admin.mapper;

import com.admin.admin.pojo.ToyMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ToyMessageMapper {
    void deleteByPrimaryKey(Integer mId);
    void insert(ToyMessage record);
    List<ToyMessage> selectAll();

    ToyMessage selectByPrimaryKey(Integer mId);
    void updateByPrimaryKey(ToyMessage record);

    int countAll();

    List<ToyMessage> selectByparent(Integer parent);


}