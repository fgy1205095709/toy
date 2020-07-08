package com.admin.admin.service;

import com.admin.admin.pojo.ToyCreateidea;
import com.admin.admin.pojo.ToyCreateideaAll;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-16 13:50
 */
public interface ToyCreateIdeaService {
    List<ToyCreateideaAll> selectAll();
    void deleteByPrimaryKey(Integer ciId);
    int count();
    void updatestate(Integer ciId,Integer ciState);
    ToyCreateideaAll selectByPrimaryKey(Integer ciId);

    void updateifcheck(ToyCreateidea toyCreateidea);

    List<ToyCreateideaAll> selectbystate();

    List<ToyCreateideaAll> selectbystitle(String title);

    List<ToyCreateidea> selectbyuser(Integer userid);
}
