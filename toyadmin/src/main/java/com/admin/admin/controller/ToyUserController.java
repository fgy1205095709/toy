package com.admin.admin.controller;

import com.admin.admin.pojo.*;
import com.admin.admin.service.ToyCreateIdeaService;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.service.ToyMessageService;
import com.admin.admin.service.ToyUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-12 14:58
 */
@Controller
public class ToyUserController {
    @Autowired
    private ToyLogService toyLogService;
    @Autowired
    private ToyUserService toyUserService;
    @Autowired
    private ToyMessageService toyMessageService;
    @Autowired
    private ToyCreateIdeaService toyCreateIdeaService;
    @RequestMapping("/showuser")
    public String showUser(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        //计算总数分页
        int all = toyUserService.countAll ();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);
        List<ToyUser> list=toyUserService.selectAll();
        model.addAttribute("USERLIST",list);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "user.html";
    }

    @RequestMapping("/usersearchid")
    public String finduserid(Model model, HttpServletRequest request,Integer uId){
        ToyUser toyUser=toyUserService.selectByPrimaryKey(uId);
        model.addAttribute ("FINDUSERID",toyUser);
        //该用户的所有创意
        List<ToyCreateidea> list=toyCreateIdeaService.selectbyuser(toyUser.getuId());
        model.addAttribute ("list",list);
        //日志
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"查看了用户的信息：<a href='http://localhost:8087/usersearchid?uId="+uId+"'>用户链接</a>");
        toyLogService.insert(log);

        return "userview.html";
    }

    @RequestMapping("/userupdate")
    public String update(ToyUser record){
        toyUserService.updateByPrimaryKey(record);
        return "redirect:/showuser";
    }
    @RequestMapping("/sendmuser")
    public String sendmessage(ToyMessage toyMessage, HttpServletRequest request){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        toyMessage.setmSendmId(user.getaId());
        toyMessageService.insert2(toyMessage);
        return "redirect:/showuser";
    }
}
