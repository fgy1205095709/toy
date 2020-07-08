package com.admin.admin.controller;

import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyLogWithBLOBs;
import com.admin.admin.pojo.ToyMessage;
import com.admin.admin.pojo.ToyUser;
import com.admin.admin.service.ToyAdminService;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.service.ToyMessageService;
import com.admin.admin.service.ToyUserService;
import com.admin.admin.util.IDUtils;
import com.admin.admin.util.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
 * @time 2019-9-12 16:38
 */
@Controller
public class ToyMessageController {
    @Autowired
    private ToyLogService toyLogService;
    @Autowired
    private ToyMessageService toyMessageService;
    @Autowired
    private ToyUserService toyUserService;
    @RequestMapping("/messageshow")//显示消息界面
    public String showMessage(@RequestParam(value = "pageNum",required=false,defaultValue = "1") int pageNum, Model model){
        int all = toyMessageService.countAll ();
        int page ;
        if (all%10 == 0) {
            page = all / 10;
        }else {
            page = all/10+1;
        }
        PageHelper.startPage (pageNum,10);
        List<ToyMessage> l = toyMessageService.selectAll();
        List<ToyUser> sUsers = toyUserService.selectAll();
        model.addAttribute("SUSER",sUsers);
        model.addAttribute ("MESSAGE",l);
        model.addAttribute ("pageNum",pageNum);
        model.addAttribute ("allNum",page);
        return "message.html";
    }

    @RequestMapping("/messagesendall")//发送给全体用户
    public String sendmessageall(HttpServletRequest request,ToyMessage record){
        List<ToyUser> sUsers = toyUserService.selectAll();
        int parent = (int) IDUtils.genItemId();
        for (ToyUser sUser : sUsers) {
            toyMessageService.insert(record,sUser.getuId(),parent);
        }
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"发送了全体消息通知");
        toyLogService.insert(log);
        return "redirect:/messageshow";
    }


    @RequestMapping("/messagesendone")//发送给单独
    public String sendmessageone(HttpServletRequest request,ToyMessage record){
        toyMessageService.insert2(record);
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"发送了单独消息通知,用户是"+record.getmBsendId());
        toyLogService.insert(log);

        return "redirect:/messageshow";
    }
    //打开详情
    @RequestMapping("/messagefindbymid")
    public String findbymid(Model model, HttpServletRequest request){
        Integer mId = Integer.parseInt (request.getParameter ("mId"));
        ToyMessage toyMessage=toyMessageService.selectByPrimaryKey(mId);
        model.addAttribute("SMESSAGEMID",toyMessage);
        return "messageview.html";
    }
    //打开主消息，显示其下的所有消息
    @RequestMapping("/messagefindbyparent")
    public String findbyparent(Model model, HttpServletRequest request){
        Integer mParent = Integer.parseInt (request.getParameter ("mParent"));
        List<ToyMessage> list=toyMessageService.selectMessageByParent(mParent);
        model.addAttribute("MESSAGEPARENT",list);
        return "messageview2.html";
    }
    @RequestMapping("/messageupdate")//修改
    public String update(ToyMessage record){
        toyMessageService.updateByPrimaryKey(record);
        return "redirect:/messageshow";

    }

    @RequestMapping("/messagedelete")//单个删除
    public String delete(Integer mId){
        toyMessageService.deleteByPrimaryKey(mId);
        return "redirect:/messageshow";

    }

    @RequestMapping("/delmesssage")//删除
    public String delete2(@RequestParam("love") Integer[] love){
        for (Integer i:love
             ) {
            toyMessageService.deleteByPrimaryKey(i);

        }
        return "redirect:/messageshow";

    }
}
