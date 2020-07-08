package com.admin.admin.controller;

import com.admin.admin.pojo.*;
import com.admin.admin.service.ToyCreateIdeaService;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.service.ToyMessageService;
import com.admin.admin.service.ToyUserService;
import com.admin.admin.util.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
 * @time 2019-9-16 14:44
 */
@Controller
public class ToyCreateIdeaController {
    @Autowired
    private ToyCreateIdeaService toyCreateIdeaService;
    @Autowired
    private ToyUserService toyUserService;
    @Autowired
    private ToyMessageService toyMessageService;
    @Autowired
    private ToyLogService toyLogService;
    //显示创意列表
    @RequestMapping("/showidea")
    public String selectAll(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        //计算总数分页
        int all = toyCreateIdeaService.count ();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);

        List<ToyCreateideaAll> list=toyCreateIdeaService.selectAll();
        model.addAttribute("IDEA",list);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "idea.html";
    }
    //修改创意的状态
    @RequestMapping("/deleteidea")
    public String del(Integer ciId,Integer ciState,HttpServletRequest request){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        //修改前对象
        ToyCreateideaAll toyCreateideaAll=toyCreateIdeaService.selectByPrimaryKey(ciId);
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"进行了修改创意状态操作");
        String oldvalue = JsonUtils.objectToJson(toyCreateideaAll);
        log.setlOldvalue(oldvalue);
        //修改操作
        toyCreateIdeaService.updatestate(ciId,ciState);
        ToyCreateideaAll toyCreateideaAll2=toyCreateIdeaService.selectByPrimaryKey(ciId);
        String newvalue = JsonUtils.objectToJson(toyCreateideaAll2);
        log.setlNewvalue(newvalue);
        toyLogService.insert(log);
        return "redirect:/showidea";
    }
    //显示这个创意的详情
    @RequestMapping("/ideafindid")
    public String searchone(HttpServletRequest request, Model model,Integer ciId){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");

        //获取显示列表数据,查找到用户
        ToyCreateideaAll toyCreateideaAll=toyCreateIdeaService.selectByPrimaryKey(ciId);
        Integer u_id=toyCreateideaAll.getCiUserid();
        ToyUser toyUser=toyUserService.selectByPrimaryKey(u_id);
        model.addAttribute("finduserid",toyUser);
        model.addAttribute("FINDID",toyCreateideaAll);


        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"查看创意:"+toyCreateideaAll.getCiTitle());
        toyLogService.insert(log);

        return "ideaview.html";
    }
    //审核创意
    @RequestMapping("/ideacheck")
    public String updateifcheck(HttpServletRequest request,ToyCreateidea toyCreateidea){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        toyCreateidea.setCiChecker(user.getaId());
        //修改是否通过审核
        toyCreateIdeaService.updateifcheck(toyCreateidea);
        //从文章id获取信息，获取文章标题
        ToyCreateideaAll idea=toyCreateIdeaService.selectByPrimaryKey(toyCreateidea.getCiId());
        //发送消息通知用户文章是否通过审核
        ToyMessage toyMessage=new ToyMessage();
        toyMessage.setmSendmId(user.getaId());
        toyMessage.setmBsendId(idea.getCiUserid());
        String jeiguo=null;
        if(toyCreateidea.getCiIfcheck()==1){
            toyMessage.setmTitle("您的"+idea.getCiTitle()+"通过审核");
            toyMessage.setmContent("您的"+idea.getCiTitle()+"通过审核"+"\n"+toyCreateidea.getCiMark());
            jeiguo="成功";
        }
        if(toyCreateidea.getCiIfcheck()==2){
            toyMessage.setmTitle("您的"+idea.getCiTitle()+"未通过审核");
            toyMessage.setmContent("您的"+idea.getCiTitle()+"未通过审核"+"\n"+toyCreateidea.getCiMark());
            jeiguo="失败";
        }
        toyMessageService.insert2(toyMessage);

        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"审核了"+idea.getCiTitle()+"审核结果是："+jeiguo);
        toyLogService.insert(log);

        return "redirect:/showidea";
    }
    //发送给这个创意的用户消息
    @RequestMapping("/sendmideauser")
    public String sendmessage(ToyMessage toyMessage, HttpServletRequest request){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        toyMessage.setmSendmId(user.getaId());
        toyMessageService.insert2(toyMessage);
        return "redirect:/showidea";
    }
    //创意删除显示（超级管理员操作）
    @RequestMapping("ideadeleteshow")
    public String deleteshow(Model model){
        List<ToyCreateideaAll> list=toyCreateIdeaService.selectbystate();
        model.addAttribute("IDEA",list);
        return "ideadelete";

    }
    //创意删除（超级管理员操作）
    @RequestMapping("ideadelete")
    public String deleteidea(Integer ciId){
        toyCreateIdeaService.deleteByPrimaryKey(ciId);
        return "redirect:/showidea";
    }
    //查询创意
    @RequestMapping("/searchidea")
    public String selectMo(String title,Model model){
        List<ToyCreateideaAll> list=toyCreateIdeaService.selectbystitle(title);
        model.addAttribute("IDEA",list);
        return "ideasearch.html";
    }
}
