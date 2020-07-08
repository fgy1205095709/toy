package com.admin.admin.controller;

import com.admin.admin.pojo.LayuiPageInfo;
import com.admin.admin.pojo.ToyLog;
import com.admin.admin.pojo.ToyLogWithBLOBs;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.util.ResultBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @anther fgy
 * @title
 * @time 2019-11-10 13:00
 */
@Controller
public class ToyLogController {
    @Autowired
    private ToyLogService toyLogService;
    @RequestMapping("/showlog")
    public String showlog(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        //计算总数分页
        int all = toyLogService.count();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);
        List<ToyLogWithBLOBs> list=toyLogService.selectAll();
        model.addAttribute("log",list);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "log";
    }

    @RequestMapping(value = "showlog2")
    @ResponseBody
    public List<ToyLogWithBLOBs> getPageList(){
        List<ToyLogWithBLOBs> pageInfo= toyLogService.selectAll();
        System.out.println(22);
        return pageInfo;
    }

    @RequestMapping(value = "showlog3")
    @ResponseBody
    public LayuiPageInfo getPageList(@RequestBody Map<String,Object> params) throws Exception{
        LayuiPageInfo<ToyLogWithBLOBs> pageInfo=null;
        try{
            pageInfo= toyLogService.getList(params);
        }catch (Exception e){
            System.out.println(123);        }
        return pageInfo;
    }
    @RequestMapping(value = "delLog")
    @ResponseBody
    public ResultBean delProject(Integer id) throws Exception{
        ResultBean resultBean=new ResultBean();
        System.out.println(123);
        try{

            toyLogService.del(id);
        }catch (IllegalArgumentException e){
            resultBean.setSuccess(false);
            resultBean.setMsg("非法参数异常："+e.getMessage());
        }catch (NullPointerException e){
            resultBean.setSuccess(false);
            resultBean.setMsg("NPE异常："+e.getMessage());
        }catch (Exception e){
            resultBean.setSuccess(false);
        }
        return resultBean;
    }
}
