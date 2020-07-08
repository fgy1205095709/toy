package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyAdminMapper;
import com.admin.admin.mapper.ToyReportMapper;
import com.admin.admin.mapper.ToyUserMapper;
import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyReport;
import com.admin.admin.pojo.ToyReportall;
import com.admin.admin.pojo.ToyUser;
import com.admin.admin.service.ToyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-13 16:22
 */
@Service
public class ToyReportServiceImpl implements ToyReportService {
    @Autowired
    private ToyReportMapper toyReportMapper;
    @Autowired
    private ToyUserMapper toyUserMapper;
    @Autowired
    private ToyAdminMapper toyAdminMapper;

    @Override
    public void deleteByPrimaryKey(Integer reId) {

    }

    @Override
    public void insert(ToyReport record) {

    }

//    @Override
//    public List<ToyReportall> selectAll() {
//        List<ToyReportall> list=new ArrayList<ToyReportall>();
//        //获取举报人和被举报人的姓名。创建一个新的类，存放两者的信息
//        List<ToyReport> list1=toyReportMapper.selectuser();
//        List<ToyReport> list2=toyReportMapper.selectbuser();
//        List<ToyAdmin> list3=toyAdminMapper.selectAll();
//        for (ToyReport toyReport: list1) {
//            for (ToyReport toyReport2: list2) {
//                ToyReportall all=new ToyReportall();
//
//                //如果两者列表的每一行一致，会录入到新的对象中
//                if(toyReport.getReBuserid()==toyReport2.getReBuserid()&&toyReport.getReUserid()==toyReport2.getReUserid()){
//                    all.setReId(toyReport.getReId());
//                    //接收被举报人的信息
//                    all.setBuserid(toyReport2.getToyUser().getuId());
//                    all.setBname(toyReport2.getToyUser().getuName());
//                    all.setBusername(toyReport2.getToyUser().getuUsername());
//                    all.setBtruename(toyReport2.getToyUser().getuTruename());
//                    //接收举报人的信息
//                    all.setUserid(toyReport.getToyUser().getuId());
//                    all.setUsername(toyReport.getToyUser().getuUsername());
//                    all.setName(toyReport.getToyUser().getuName());
//                    all.setTruename(toyReport.getToyUser().getuTruename());
//
//                    all.setReIdeaid(toyReport.getReIdeaid());
//                    all.setReContent(toyReport.getReContent());
//                    all.setReType(toyReport.getReType());
//                    all.setReTypetwo(toyReport.getReTypetwo());
//                    all.setReAdminid(toyReport.getReAdminid());
//                    all.setReIf(toyReport.getReIf());
//                    all.setReIsitvalid(toyReport.getReIsitvalid());
//                    all.setReUrsid(toyReport.getReUrsid());
//                    all.setReTime(toyReport.getReTime());
//                    all.setReResult(toyReport.getReResult());
//                    all.setReResulttime(toyReport.getReResulttime());
//                    all.setReReason(toyReport.getReReason());
//                    all.setReOne(toyReport.getReOne());
//                    for (ToyAdmin toyadmin:list3) {
//                        if(toyadmin.getaId()==toyReport.getReAdminid()){
//                            all.setToyAdmin(toyadmin);
//                            break;
//                        }else {
//                            toyadmin.setaId(9999);
//                            all.setToyAdmin(toyadmin);
//                        }
//                    }
//                    list.add(all);
//                }
//            }
//        }
//        return list;
//    }
    @Override
    public List<ToyReportall> selectAll() {
        List<ToyReportall> list=new ArrayList<ToyReportall>();
        //获取举报人和被举报人的姓名。创建一个新的类，存放两者的信息
        List<ToyReport> list1=toyReportMapper.selectAll();
        List<ToyUser> list2 =toyUserMapper.selectAll();
        List<ToyAdmin> list3=toyAdminMapper.selectAll();
        for (ToyReport toyReport:list1) {
            ToyReportall all=new ToyReportall();
            for (ToyUser user:list2) {
                if(toyReport.getReUserid().equals(user.getuId())){
                    all.setUserid(user.getuId());
                    all.setUsername(user.getuUsername());
                    all.setName(user.getuName());
                    all.setTruename(user.getuTruename());
                    continue;
                }
                if(toyReport.getReBuserid().equals(user.getuId())){
                    all.setBuserid(user.getuId());
                    all.setBname(user.getuName());
                    all.setBusername(user.getuUsername());
                    all.setBtruename(user.getuTruename());
                    continue;
                }
            }

            all.setReId(toyReport.getReId());
            all.setReIdeaid(toyReport.getReIdeaid());
            all.setReContent(toyReport.getReContent());
            all.setReType(toyReport.getReType());
            all.setReTypetwo(toyReport.getReTypetwo());
            all.setReAdminid(toyReport.getReAdminid());
            all.setReIf(toyReport.getReIf());
            all.setReIsitvalid(toyReport.getReIsitvalid());
            all.setReUrsid(toyReport.getReUrsid());
            all.setReTime(toyReport.getReTime());
            all.setReResult(toyReport.getReResult());
            all.setReResulttime(toyReport.getReResulttime());
            all.setReReason(toyReport.getReReason());
            all.setReOne(toyReport.getReOne());
            for (ToyAdmin toyadmin:list3) {
                if(toyadmin.getaId()==toyReport.getReAdminid()){
                    all.setToyAdmin(toyadmin);
                }else {
                    toyadmin.setaId(9999);
                    all.setToyAdmin(toyadmin);
                }
            }
            list.add(all);
        }
        return list;
    }
    @Override
    public int countall() {
        return toyReportMapper.countall();
    }

    @Override
    public ToyReportall selectByPrimaryKey(Integer reId) {

        ToyReport toyReport=toyReportMapper.selectByPrimaryKey(reId);
        List<ToyUser> list =toyUserMapper.selectAll();
        List<ToyAdmin> list2=toyAdminMapper.selectAll();
        ToyReportall toyReportall=new ToyReportall();

        for (ToyUser toyUser:list) {
            if(toyReport.getReUserid().equals(toyUser.getuId())){
                toyReportall.setUserid(toyUser.getuId());
                toyReportall.setUsername(toyUser.getuUsername());
                toyReportall.setName(toyUser.getuName());
                toyReportall.setTruename(toyUser.getuTruename());

            }
            if(toyReport.getReBuserid().equals(toyUser.getuId())){
                toyReportall.setBuserid(toyUser.getuId());
                toyReportall.setBusername(toyUser.getuUsername());
                toyReportall.setBname(toyUser.getuName());
                toyReportall.setBtruename(toyUser.getuTruename());
            }
            if(toyReportall.getBuserid()!=null&&toyReportall.getUserid()!=null){
                break;
            }
            for (ToyAdmin toyAdmin:list2) {
                if(toyAdmin.getaId().equals(toyReport.getReAdminid())){
                    toyReportall.setToyAdmin(toyAdmin);
                    break;
                }else {
                    toyAdmin.setaId(9999);
                    toyReportall.setToyAdmin(toyAdmin);
                }
            }
        }
        toyReportall.setReId(toyReport.getReId());
        toyReportall.setReTime(toyReport.getReTime());
        toyReportall.setReType(toyReport.getReType());
        toyReportall.setReTypetwo(toyReport.getReTypetwo());
        toyReportall.setReContent(toyReport.getReContent());
        toyReportall.setReReason(toyReport.getReReason());
        toyReportall.setReIsitvalid(toyReport.getReIsitvalid());
        toyReportall.setReResult(toyReport.getReResult());
        toyReportall.setReResulttime(toyReport.getReResulttime());
        toyReportall.setReIf(toyReport.getReIf());
        return toyReportall;
    }

    @Override
    public void updateByPrimaryKey(ToyReport record) {
        record.setReResulttime(new Date());
        record.setReIf(2);
        toyReportMapper.updateByPrimaryKey(record);
    }

    @Override
    public int countif() {
        return toyReportMapper.countif();
    }
}
