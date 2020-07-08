package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyMessageMapper;
import com.admin.admin.pojo.ToyMessage;
import com.admin.admin.service.ToyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-12 16:36
 */
@Service
public class ToyMessageServiceImpl implements ToyMessageService {

    @Autowired
    private ToyMessageMapper toyMessageMapper;
    @Override
    public void deleteByPrimaryKey(Integer mId) {
        toyMessageMapper.deleteByPrimaryKey(mId);
    }

    @Override
    public void insert(ToyMessage record,Integer mBId,Integer mParent) {
        if(mBId!=10000){
            record.setmMessage("1");
        }else {
            record.setmMessage("2");
        }
        record.setmBsendId(mBId);
        record.setmType(1);
        record.setmParent(mParent);
        record.setmTime(new Date());
        record.setmState(1);
        toyMessageMapper.insert(record);
    }

    @Override
    public void insert2(ToyMessage record) {
        record.setmTime(new Date());
        record.setmType(1);
        record.setmMessage("2");
        record.setmState(1);
        toyMessageMapper.insert(record);
    }

    @Override
    public void insertreport(Integer userid, Integer adminid, Integer iftrue, String content) {
        //管理员向举报者发送消息
        ToyMessage record =new ToyMessage();
        if(iftrue==1){
            record.setmTitle("您的举报成功");
        }else{
            record.setmTitle("您的举报失败");
        }
        record.setmTime(new Date());
        record.setmType(1);
        record.setmMessage("2");
        record.setmState(1);
        record.setmBsendId(userid);
        record.setmSendmId(adminid);
        record.setmContent(content);
        toyMessageMapper.insert(record);
    }
    @Override
    public void insertreporttrue(Integer userid, Integer adminid, Integer iftrue, String content) {
        //管理员向举报者发送消息
        ToyMessage record =new ToyMessage();
        record.setmTitle("匿名用户对您的举报成功");
        record.setmTime(new Date());
        record.setmType(1);
        record.setmMessage("2");
        record.setmState(1);
        record.setmBsendId(userid);
        record.setmSendmId(adminid);
        record.setmContent(content);
        toyMessageMapper.insert(record);
    }
    @Override
    public List<ToyMessage> selectAll() {

        return toyMessageMapper.selectAll();
    }

    @Override
    public ToyMessage selectByPrimaryKey(Integer mId) {
        return toyMessageMapper.selectByPrimaryKey(mId);
    }

    @Override
    public void updateByPrimaryKey(ToyMessage record) {
        toyMessageMapper.updateByPrimaryKey(record);
    }

    @Override
    public int countAll() {
        return toyMessageMapper.countAll();
    }

    @Override
    public List<ToyMessage> selectMessageByParent(Integer mParent) {
        return toyMessageMapper.selectByparent(mParent);
    }
}
