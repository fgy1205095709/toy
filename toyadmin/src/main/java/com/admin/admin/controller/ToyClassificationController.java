package com.admin.admin.controller;

import com.admin.admin.pojo.ToyClassification;
import com.admin.admin.service.ToyClassificationService;
import com.admin.admin.service.impl.ToyClassificationServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-10 19:22
 */
@Controller
public class ToyClassificationController {
    @Autowired
    private ToyClassificationService toyClassificationService;
    @RequestMapping("/showclassification")
    public String selectAllType(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        //计算总数分页
        int all = toyClassificationService.countAll ();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);
        List<ToyClassification> list=toyClassificationService.selectAll();
        model.addAttribute("Toytype",list);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "classification.html";
    }
    //修改分类
    @RequestMapping("/updatetype")
    public String updatetype(ToyClassification record){
        toyClassificationService.updateByPrimaryKey(record);
        return "redirect:/showclassification";

    }
}
