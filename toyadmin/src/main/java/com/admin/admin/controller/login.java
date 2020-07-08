package com.admin.admin.controller;

import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyUser;
import com.admin.admin.service.ToyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @anther fgy
 * @title
 * @time 2019-10-11 10:40
 */
@Controller
public class login {


    @RequestMapping("/logina")
    @ResponseBody
    public String login( @RequestBody ToyUser toyUser){
        System.out.println(toyUser.getuUsername());
        short s1=1;
        s1+=1;
        return "123";
    }

}
