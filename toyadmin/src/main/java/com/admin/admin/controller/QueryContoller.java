package com.admin.admin.controller;

import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyLogWithBLOBs;
import com.admin.admin.service.QueryService;
import com.admin.admin.service.ToyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @anther fgy
 * @title
 * @time 2019-9-13 13:54
 */
@Controller
public class QueryContoller {
    @Autowired
    private QueryService queryService;
    @Autowired
    private ToyLogService toyLogService;
    //重新导入索引库
    @RequestMapping("/deletequery")
    public String delete(HttpServletRequest request){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        queryService.delete();
        queryService.add();
        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"将创意重新导入索引库");
        toyLogService.insert(log);
        return "redirect:/loginOut";
    }
    @RequestMapping("/deletequery2")
    public void delete2(){
        queryService.delete();
        queryService.add();
        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("用户发布创意多了十条，在"+new Date()+"将创意重新导入索引库");
        toyLogService.insert(log);
    }
}
