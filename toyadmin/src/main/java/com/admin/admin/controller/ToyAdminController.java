package com.admin.admin.controller;

import com.admin.admin.pojo.Homepage;
import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyLogWithBLOBs;
import com.admin.admin.pojo.ToyUser;
import com.admin.admin.service.*;
import com.admin.admin.util.JsonUtils;
import com.admin.admin.util.jedis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Maps;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @anther fgy
 * @title
 * @time 2019-9-10 20:04
 */
@Controller
public class ToyAdminController {
    private final static Logger logger = LoggerFactory.getLogger(ToyAdminController.class);
    @Autowired
    private ToyAdminService toyAdminService;
    @Autowired
    private ToyReportService toyReportService;
    @Autowired
    private ToyClassificationService toyClassificationService;
    @Autowired
    private ToyCreateIdeaService toyCreateIdeaService;
    @Autowired
    private ToyUserService toyUserService;
    @Autowired
    private HomepageService homepageService;
    @Autowired
    private ToyLogService toyLogService;
@RequestMapping("/log")
    public String dsd(){
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        return "redirect:/adminshow";
    }
    //登录
    @RequestMapping("/login")
    public String login(Model model, String username, String password, HttpSession session){
        ToyAdmin  toyAdmin;
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        try {
            toyAdmin=toyAdminService.selectusername(username);
        }catch (Exception e){
            model.addAttribute("msg","用户名不存在");

            return "login.html";
        }

        if(toyAdmin.getaPassword().equals(password)){
            session.setAttribute("USER",toyAdmin);
            int count=toyReportService.countif();
            session.setAttribute("countif",count);
            //计算总数
            int countnet =toyClassificationService.countnet();
            int countidea=toyCreateIdeaService.count();
            int countuser=toyUserService.countAll();
            List<Homepage> list=homepageService.showuser();
            model.addAttribute("list",list);
            model.addAttribute("countnet",countnet);
            model.addAttribute("countidea",countidea);
            model.addAttribute("countuser",countuser);
            //日志
            ToyLogWithBLOBs log=new ToyLogWithBLOBs();
            log.setlContent("管理员:"+toyAdmin.getaName()+"在"+new Date()+"登录");
            toyLogService.insert(log);
            return "homepage.html";
        }
        model.addAttribute("msg","密码错误");
        return "login.html";
    }
    //退出登录
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute ("USER");
        return "login.html";
    }
    //显示二级管理员
    @RequestMapping("/adminshow")
    public String show(Model model){
        List<ToyAdmin> l = toyAdminService.selectAll();
        model.addAttribute ("SADMIN",l);
        return "admin.html";
    }
    //显示二级管理员
    @RequestMapping(value = "/showtubiao")
    @ResponseBody
    public Map<String,Object> show2(){
        System.out.println(1);
        return toyAdminService.selectname();
    }
    //显示二级管理员
    @RequestMapping(value = "/showtubiao2")
    @ResponseBody
    public Map<String,String> show3(){
        System.out.println(1);
        return toyAdminService.selectname2();
    }









    //添加管理员
    @RequestMapping("/adminadd")
    public String insert(ToyAdmin toyAdmin){
        toyAdminService.insert(toyAdmin);
        return "redirect:/adminshow";
    }
    //管理员修改自身账号密码个人信息
    @RequestMapping("/updatepassword")
    public  String update(ToyAdmin toyAdmin){
        toyAdminService.updateByPrimaryKey(toyAdmin);
        return "redirect:/loginOut";
    }
    //修改管理员
    @RequestMapping("/updateadmin")
    public String updateadmin(ToyAdmin toyAdmin){
        toyAdminService.updateByPrimaryKey(toyAdmin);
        return "redirect:/adminshow";
    }
    //删除管理员
    @RequestMapping("/deleteadminuser")
    public String delete(Integer aId){
        toyAdminService.deleteByPrimaryKey(aId);
        return "redirect:/adminshow";
    }

    //删除管理员
    @RequestMapping("/gundong")
    public String gundong(Model model){
        List<ToyUser> list=toyUserService.selectAll();
        model.addAttribute("size",list.size());
        System.out.println(list.size());
        model.addAttribute("USERLIST",list);
        return "gundong";
    }
}
