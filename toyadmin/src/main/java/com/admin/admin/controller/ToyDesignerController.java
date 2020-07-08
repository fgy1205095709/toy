package com.admin.admin.controller;

import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyDesigner;
import com.admin.admin.pojo.ToyMessage;
import com.admin.admin.service.ToyDesignerService;
import com.admin.admin.service.ToyMessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-16 19:56
 */
@Controller
public class ToyDesignerController {
    @Autowired
    private ToyDesignerService toyDesignerService;
    @Autowired
    private ToyMessageService toyMessageService;

    @RequestMapping("/showdesigner")
    public String showdesigner(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, Model model) {
        //计算总数分页
        int all = toyDesignerService.count();
        int page;
        if (all % 10 == 0) {
            page = all / 10;
        } else {
            page = all / 10 + 1;
        }
        PageHelper.startPage(pageNum, 10);
        List<ToyDesigner> list = toyDesignerService.selectAll();
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("allNum", page);
        model.addAttribute("DESIGNER", list);
        return "designer.html";
    }

    //发送消息给设计师
    @RequestMapping("/sendmdesigner")
    public String sendmessage(ToyMessage toyMessage, HttpServletRequest request) {
        ToyAdmin user = (ToyAdmin) request.getSession().getAttribute("USER");
        toyMessage.setmSendmId(user.getaId());
        toyMessageService.insert2(toyMessage);
        return "redirect:/showdesigner";
    }

    @RequestMapping("/updateGrade")
    public String updateGrade(ToyDesigner toyDesigner) {
        toyDesignerService.updateByGrade(toyDesigner);
        return "redirect:/showdesigner";
    }
}