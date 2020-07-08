package com.admin.admin.mapper;

import com.admin.admin.pojo.ToyAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ToyAdminMapper {
    List<ToyAdmin> selectAll();
   List<ToyAdmin> selectname();
    void deleteByPrimaryKey(Integer aId);
    void insert(ToyAdmin record);
    void updateByPrimaryKey(ToyAdmin toyAdmin);
    ToyAdmin selectusername(String username);
}