package com.admin.admin.service;

import com.admin.admin.pojo.ToyMessage;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-12 16:35
 */
public interface ToyMessageService {
    //删除消息
    void deleteByPrimaryKey(Integer mId);
    //添加
    void insert(ToyMessage record,Integer mBId,Integer mParent);
    //添加方法
    void insert2(ToyMessage record);
    //发送给举报成功
    void insertreport(Integer userid,Integer adminid, Integer iftrue,String content);
    //发送给被举报人
    void insertreporttrue(Integer userid,Integer adminid, Integer iftrue,String content);
    //显示全部已读未读的信息
    List<ToyMessage> selectAll();
    //获取详情
    ToyMessage selectByPrimaryKey(Integer mId);
    //修改
    void updateByPrimaryKey(ToyMessage record);
    //计算总数
    int countAll();
    //管理员发布的总记录，里面有很多条子数据
    List<ToyMessage> selectMessageByParent(Integer mParent);
}
