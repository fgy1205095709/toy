package com.admin.admin.controller;

import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyLogWithBLOBs;
import com.admin.admin.pojo.ToyMessage;
import com.admin.admin.pojo.ToyOrder;
import com.admin.admin.service.ToyLogService;
import com.admin.admin.service.ToyMessageService;
import com.admin.admin.service.ToyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-18 21:19
 */
@Controller
public class ToyOrderController {
    @Autowired
    private ToyLogService toyLogService;
    @Autowired
    private ToyOrderService toyOrderService;
    @Autowired
    private ToyMessageService toyMessageService;
    @RequestMapping("ordershow")
    public String show(Model model){
        List<ToyOrder> list=toyOrderService.selectByExample();
        model.addAttribute("list",list);
        return "order";
    }

    @RequestMapping("checkorder")
    public String check(ToyOrder toyOrder,HttpServletRequest request){
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");

        String result="";
        toyOrderService.updatecheck(toyOrder);
        ToyOrder toyOrder2=toyOrderService.selectone(toyOrder.getoId());
        if(toyOrder.getoIf()==2){
            ToyMessage toyMessage=new ToyMessage();
            toyMessage.setmTitle("您的申请已通过");
            toyMessage.setmContent("以下是设计师的手机号信息，请您联系:"+toyOrder2.getoBuserphone());
            toyMessage.setmSendmId(user.getaId());
            toyMessage.setmBsendId(toyOrder2.getoUserid());
            toyMessageService.insert2(toyMessage);
            toyMessage.setmBsendId(toyOrder2.getoBuserid());
            toyMessage.setmTitle("您的创意有人正在购买……");
            toyMessage.setmContent("以下是用户的手机号信息:"+toyOrder2.getoUserphone());
            toyMessageService.insert2(toyMessage);
            result = "通过";
        }
        if(toyOrder.getoIf()==3){
            ToyMessage toyMessage=new ToyMessage();
            toyMessage.setmTitle("您的申请未通过");
            toyMessage.setmContent("请您完善个人信息");
            toyMessage.setmSendmId(user.getaId());
            toyMessage.setmBsendId(toyOrder2.getoUserid());
            toyMessageService.insert2(toyMessage);
            result = "未通过";

        }
        //日志
        ToyLogWithBLOBs log=new ToyLogWithBLOBs();
        log.setlContent("管理员:"+user.getaName()+"在"+new Date()+"审核了订单:"+toyOrder2.getoId()+"结果："+result);
        toyLogService.insert(log);

        return "redirect:/ordershow";
    }
}
