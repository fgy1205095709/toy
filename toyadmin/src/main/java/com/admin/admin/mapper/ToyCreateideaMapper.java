package com.admin.admin.mapper;

import com.admin.admin.pojo.Homepage;
import com.admin.admin.pojo.ToyCreateidea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ToyCreateideaMapper {

    void deleteByPrimaryKey(Integer ciId);

    List<ToyCreateidea> selectAll();
    int selectAllcount();

    ToyCreateidea selectByPrimaryKey(Integer ciId);

    void updateByPrimaryKeyWithBLOBs(ToyCreateidea record);


    void updatestate(Integer ciId,Integer ciState);

    void updateifcheck(ToyCreateidea toyCreateidea);

    List<ToyCreateidea> selectstate();

    List<Homepage> selectideacount();

    List<Homepage> selectorder();

    List<ToyCreateidea> selecttitle(String title);

    List<ToyCreateidea> selectbyuser(Integer ciUserid);
}