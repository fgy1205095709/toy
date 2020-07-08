package com.admin.admin.service;

import com.admin.admin.pojo.ToyAdmin;

import java.util.List;
import java.util.Map;

/**
 * @anther fgy
 * @title
 * @time 2019-9-10 20:02
 */
public interface ToyAdminService {
    List<ToyAdmin> selectAll();
    Map<String,String>  selectname2();
    Map<String,Object>  selectname();
    void deleteByPrimaryKey(Integer aId);
    void insert(ToyAdmin record);
    void updateByPrimaryKey(ToyAdmin toyAdmin);
    ToyAdmin selectusername(String username);

}
