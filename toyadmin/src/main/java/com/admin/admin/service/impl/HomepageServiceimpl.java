package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyCreateideaMapper;
import com.admin.admin.mapper.ToyUserMapper;
import com.admin.admin.pojo.Homepage;
import com.admin.admin.pojo.ToyUser;
import com.admin.admin.service.HomepageService;
import com.admin.admin.service.ToyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-10-18 20:17
 */
@Service
public class HomepageServiceimpl implements HomepageService {
    @Autowired
    private ToyUserMapper toyUserMapper;
    @Autowired
    private ToyCreateideaMapper toyCreateideaMapper;
    @Override
    public List<Homepage> showuser() {
        List<Homepage> list= toyCreateideaMapper.selectideacount();
        List<ToyUser> list2=toyUserMapper.selectAll();
        List<Homepage> list3=toyCreateideaMapper.selectorder();
        List<Homepage> list4= new ArrayList<>();
        for (Homepage h:list) {
            Homepage home=new Homepage();
            home.setUserideacount(h.getUserideacount());
            for (ToyUser t:list2 ) {
                if(t.getuId()==h.getUserid()){
                    home.setUname(t.getuName());
                    home.setUdescribe(t.getuDescribe());
                    home.setUphone(t.getuPhone());
                }
            }
            for (Homepage h2:list3) {
                if(h2.getUserid()==h.getUserid()){
                    home.setUserordercount(h2.getUserordercount());
                }else {
                    home.setUserordercount(0);
                }
            }
            list4.add(home);
        }
        return list4;
    }
}
