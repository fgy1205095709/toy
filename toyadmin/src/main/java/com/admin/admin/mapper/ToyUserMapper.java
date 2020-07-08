package com.admin.admin.mapper;

import com.admin.admin.pojo.Homepage;
import com.admin.admin.pojo.ToyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ToyUserMapper {
    void deleteByPrimaryKey(Integer uId);
    void insert(ToyUser record);
    List<ToyUser> selectAll();
    int countAll();
    ToyUser selectByPrimaryKey(Integer uId);
    void updateByPrimaryKey(ToyUser record);

}