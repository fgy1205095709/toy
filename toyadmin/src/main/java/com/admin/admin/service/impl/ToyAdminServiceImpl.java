package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyAdminMapper;
import com.admin.admin.pojo.ToyAdmin;
import com.admin.admin.pojo.ToyCreateideaAll;
import com.admin.admin.service.ToyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @anther fgy
 * @title
 * @time 2019-9-10 20:02
 */
@Service
public class ToyAdminServiceImpl implements ToyAdminService {
    @Autowired
    private ToyAdminMapper toyAdminMapper;
    @Override
    public List<ToyAdmin> selectAll() {

        return toyAdminMapper.selectAll();
    }

    @Override
    public Map<String, String> selectname2() {
        List<ToyAdmin> list=toyAdminMapper.selectname();
        Map<String,Object> xmap=new HashMap<String,Object>();
        String[] xxdata=new String[list.size()];
        /*创建装载月份数组*/
        String[] xdata=new String[list.size()];
        int i=0;
        for (ToyAdmin toyAdmin : list) {
            xxdata[i]=toyAdmin.getaUsername();
            xdata[i]=toyAdmin.getaPassword();
            System.out.println(toyAdmin.getaUsername());
            i++;
        }
        xmap.put("xname", xdata);
        xmap.put("xcount", xxdata);
        return null;
    }

    @Override
    public Map<String,Object>  selectname() {
        List<ToyAdmin> list=toyAdminMapper.selectname();
        Map<String,Object> xmap=new HashMap<String,Object>();
        String[] xxdata=new String[list.size()];
        /*创建装载月份数组*/
        int[] xdata=new int[list.size()];
        int i=0;
        System.out.println(list.size());
        for (ToyAdmin toyAdmin : list) {
            xxdata[i]=toyAdmin.getaUsername();
            xdata[i]=toyAdmin.getaLevel();
            System.out.println(toyAdmin.getaUsername());
            i++;
        }
        xmap.put("xname", xxdata);
        xmap.put("xcount", xdata);
        return xmap;
    }


    @Override
    public void deleteByPrimaryKey(Integer aId) {
        toyAdminMapper.deleteByPrimaryKey(aId);
    }

    @Override
    public void insert(ToyAdmin record) {
        record.setaLevel(2);
        record.setaLasttime(new Date());
        toyAdminMapper.insert(record);
    }

    @Override
    public void updateByPrimaryKey(ToyAdmin toyAdmin) {
        toyAdmin.setaLasttime(new Date());
        toyAdminMapper.updateByPrimaryKey(toyAdmin);
    }

    @Override
    public ToyAdmin selectusername(String username) {
        ToyAdmin toyAdmin=toyAdminMapper.selectusername(username);
        return toyAdmin;
    }
}
