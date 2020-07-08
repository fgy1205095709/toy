package com.admin.admin.controller;

import com.admin.admin.pojo.Homepage;
import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-12 14:45
 */
@Controller
public class ToyhomepageController {
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
    @RequestMapping("/")
    public String selectAlla(HttpSession session,HttpServletRequest request, Model model){
        //首部三个技术
        int countnet =toyClassificationService.countnet();
        int countidea=toyCreateIdeaService.count();
        int countuser=toyUserService.countAll();
        model.addAttribute("countnet",countnet);
        model.addAttribute("countidea",countidea);
        model.addAttribute("countuser",countuser);
        //首页用户排行
        List<Homepage> list=homepageService.showuser();
        model.addAttribute("list",list);
        int count=toyReportService.countif();
        session.setAttribute("countif",count);
        return "homepage.html";
    }
    @RequestMapping("{page}")
    public String page(@PathVariable String page){
        return page;
    }

}
