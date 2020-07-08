package com.admin.admin.controller;

import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyNeed;
import com.admin.admin.service.ToyNeedService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-17 15:13
 */
@Controller
public class ToyNeedController {
    @Autowired
    private ToyNeedService toyNeedService;
    @RequestMapping("showNeed")
    public String showneed(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        //计算总数分页
        int all = toyNeedService.count ();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);

        List<ToyNeed> list=toyNeedService.selectAll();
        model.addAttribute("NEED",list);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "need";
    }
    //删除需求
    @RequestMapping("deleteNeed")
    public String delete(Integer nId){
        toyNeedService.deleteByPrimaryKey(nId);
        return "redirect:/showNeed";
    }
    //审核需求
    @RequestMapping("checkNeed")
    public String checknId(HttpServletRequest request,ToyNeed toyNeed){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        toyNeed.setnChecker(user.getaId());
        toyNeed.setnChecktime(new Date());
        System.out.println(toyNeed.getnId());
        toyNeedService.update(toyNeed);
        return "redirect:/showNeed";
    }

}

