package com.admin.admin.controller;

import com.admin.admin.pojo.*;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.service.ToyMessageService;
import com.admin.admin.service.ToyReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-13 16:23
 */
@Controller
public class ToyReportController {
    @Autowired
    private ToyLogService toyLogService;
    @Autowired
    private ToyReportService toyReportService;
    @Autowired
    private ToyMessageService toyMessageService;
    @RequestMapping("/showreport")
    public String showreport(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        //计算总数分页
        int all = toyReportService.countall ();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);
        List<ToyReportall> list = toyReportService.selectAll();
        model.addAttribute("SHOWREPORT",list);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "report.html";
    }
    //管理员处理举报
    @RequestMapping("/reportupdate")
    public String reportupdate(HttpServletRequest request,ToyReport record ,Integer userid ,Integer buserid){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        record.setReAdminid(user.getaId());
        //处理举报
        toyReportService.updateByPrimaryKey(record);
        //向举报者发送处理结果
        toyMessageService.insertreport(userid,user.getaId(),record.getReIsitvalid(),record.getReResult());
        String jieguo="失败";
        //向被举报者发送消息（举报成功）
        if(record.getReIsitvalid()==1){
             toyMessageService.insertreporttrue(buserid,user.getaId(),record.getReIsitvalid(),record.getReOne());
            jieguo="成功";
        }

        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"处理了举报："+record.getReId()+"举报结果:"+jieguo);
        toyLogService.insert(log);


        return "redirect:/showreport";
    }

    @RequestMapping("/findbyreportid")
    public String reportselectone(Model model, HttpServletRequest request){
        //显示举报情况
        Integer reId = Integer.parseInt (request.getParameter ("reId"));
        ToyReportall toyReportall=toyReportService.selectByPrimaryKey(reId);
        model.addAttribute("FINDBYREPORTID",toyReportall);
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"查看了举报："+reId);
        toyLogService.insert(log);
        return "reportview.html";
    }
}
