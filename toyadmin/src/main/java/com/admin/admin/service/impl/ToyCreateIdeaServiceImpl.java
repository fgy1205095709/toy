package com.admin.admin.service.impl;

import com.admin.admin.mapper.ToyClassificationMapper;
import com.admin.admin.mapper.ToyCreateideaMapper;
import com.admin.admin.pojo.ToyClassification;
import com.admin.admin.pojo.ToyCreateidea;
import com.admin.admin.pojo.ToyCreateideaAll;
import com.admin.admin.service.ToyCreateIdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-16 13:51
 */
@Service
public class ToyCreateIdeaServiceImpl implements ToyCreateIdeaService {
    @Autowired
    private ToyCreateideaMapper toyCreateideaMapper;
    @Autowired
    private ToyClassificationMapper toyClassificationMapper;
    @Override
    public List<ToyCreateideaAll> selectAll() {
        //显示全部，需要置换掉原有表中的信息，把用户id，类别信息全部替换成文字
        List<ToyCreateidea> list=toyCreateideaMapper.selectAll();
        List<ToyClassification> type=toyClassificationMapper.selectAll();
        List<ToyCreateideaAll> listall=new ArrayList<ToyCreateideaAll>();
//        //外层循环循环准备替换掉所有分类的id，全部转换为名字
        for (ToyCreateidea toyCreateidea:list) {
            ToyCreateideaAll all=new ToyCreateideaAll();

            for (ToyClassification t:type) {
                if(toyCreateidea.getCiKind().equals(t.getcId())){
                        all.setKindname(t.getcName());
                }
                if(toyCreateidea.getCiAgegroup().equals(t.getcId())){
                        all.setAgename(t.getcName()+"岁");
                    }
                if(toyCreateidea.getCiTexture().equals(t.getcId())){
                    all.setTexturename(t.getcName());
                }
                if(toyCreateidea.getCiFunction().equals(t.getcId())){
                    all.setFunctionname(t.getcName());
                }
            }
            all.setCiId(toyCreateidea.getCiId());
            all.setCiAction(toyCreateidea.getCiAction());
            all.setCiChecker(toyCreateidea.getToyAdmin().getaId());
            all.setCiCheckername(toyCreateidea.getToyAdmin().getaName());
            all.setCiCheckerusername(toyCreateidea.getToyAdmin().getaUsername());
            all.setCiUserid(toyCreateidea.getToyUser().getuId());
            all.setCiUsername(toyCreateidea.getToyUser().getuName());
            all.setCiUserusername(toyCreateidea.getToyUser().getuUsername());
            all.setCiUserimg(toyCreateidea.getToyUser().getuHead());
            all.setCiState(toyCreateidea.getCiState());
            all.setCiPubtime(toyCreateidea.getCiPubtime());
            all.setCiMark(toyCreateidea.getCiMark());
            all.setCiScan(toyCreateidea.getCiScan());
            all.setCiTitle(toyCreateidea.getCiTitle());
            all.setCiContent(toyCreateidea.getCiContent());
            all.setCiImg(toyCreateidea.getCiImg());
            listall.add(all);

        }
        return listall;
    }

    @Override
    public void deleteByPrimaryKey(Integer ciId) {
        toyCreateideaMapper.deleteByPrimaryKey(ciId);
    }

    @Override
    public int count() {
        int count =toyCreateideaMapper.selectAllcount();
        return count;
    }

    @Override
    public void updatestate(Integer ciId, Integer ciState) {

        toyCreateideaMapper.updatestate(ciId,ciState);
    }

    @Override
    public ToyCreateideaAll selectByPrimaryKey(Integer ciId) {
        //接收这个id的信息
        ToyCreateidea toyCreateidea=toyCreateideaMapper.selectByPrimaryKey(ciId);
        //接收种类表数据
        List<ToyClassification> list=toyClassificationMapper.selectAll();
        //创建接收对象
        ToyCreateideaAll all=new ToyCreateideaAll();
        //数据比对，替换文字
        for (ToyClassification toy:list) {
            if(toy.getcId().equals(toyCreateidea.getCiKind())){
                all.setKindname(toy.getcName());
            }
            if(toy.getcId().equals(toyCreateidea.getCiTexture())){
                all.setTexturename(toy.getcName());
            }
            if(toy.getcId().equals(toyCreateidea.getCiAgegroup())){
                all.setAgename(toy.getcName());
            }
            if(toy.getcId().equals(toyCreateidea.getCiFunction())){
                all.setFunctionname(toy.getcName());
            }
        }
        all.setCiUserid(toyCreateidea.getCiUserid());
        all.setCiTitle(toyCreateidea.getCiTitle());
        all.setCiContent(toyCreateidea.getCiContent());
        all.setCiId(toyCreateidea.getCiId());
        all.setCiScan(toyCreateidea.getCiScan());
        all.setCiState(toyCreateidea.getCiState());
        all.setCiAction(toyCreateidea.getCiAction());

        return all;
    }

    @Override
    public void updateifcheck(ToyCreateidea toyCreateidea) {
        if(toyCreateidea.getCiIfcheck()==1){
            toyCreateidea.setCiState(1);
        }
        if(toyCreateidea.getCiIfcheck()==2){
            toyCreateidea.setCiState(4);
        }
        toyCreateidea.setCiChecktime(new Date());
        toyCreateideaMapper.updateifcheck(toyCreateidea);
    }

    @Override
    public List<ToyCreateideaAll> selectbystate() {
        //显示全部，需要置换掉原有表中的信息，把用户id，类别信息全部替换成文字
        List<ToyCreateidea> list=toyCreateideaMapper.selectstate();
        List<ToyClassification> type=toyClassificationMapper.selectAll();
        List<ToyCreateideaAll> listall=new ArrayList<ToyCreateideaAll>();
//        //外层循环循环准备替换掉所有分类的id，全部转换为名字
        for (ToyCreateidea toyCreateidea:list) {
            ToyCreateideaAll all=new ToyCreateideaAll();

            for (ToyClassification t:type) {
                if(toyCreateidea.getCiKind().equals(t.getcId())){
                    all.setKindname(t.getcName());
                }
                if(toyCreateidea.getCiAgegroup().equals(t.getcId())){
                    all.setAgename(t.getcName()+"岁");
                }
                if(toyCreateidea.getCiTexture().equals(t.getcId())){
                    all.setTexturename(t.getcName());
                }
                if(toyCreateidea.getCiFunction().equals(t.getcId())){
                    all.setFunctionname(t.getcName());
                }
            }
            all.setCiId(toyCreateidea.getCiId());
            all.setCiAction(toyCreateidea.getCiAction());

            all.setCiUserid(toyCreateidea.getToyUser().getuId());
            all.setCiUsername(toyCreateidea.getToyUser().getuName());
            all.setCiUserusername(toyCreateidea.getToyUser().getuUsername());
            all.setCiUserimg(toyCreateidea.getToyUser().getuHead());
            all.setCiState(toyCreateidea.getCiState());
            all.setCiPubtime(toyCreateidea.getCiPubtime());
            all.setCiMark(toyCreateidea.getCiMark());
            all.setCiScan(toyCreateidea.getCiScan());
            all.setCiTitle(toyCreateidea.getCiTitle());
            all.setCiContent(toyCreateidea.getCiContent());
            all.setCiImg(toyCreateidea.getCiImg());
            listall.add(all);

        }
        return listall;
    }

    @Override
    public List<ToyCreateideaAll> selectbystitle(String title) {
        //显示全部，需要置换掉原有表中的信息，把用户id，类别信息全部替换成文字
        List<ToyCreateidea> list=toyCreateideaMapper.selecttitle("%"+title+"%");
        List<ToyClassification> type=toyClassificationMapper.selectAll();
        List<ToyCreateideaAll> listall=new ArrayList<ToyCreateideaAll>();
//        //外层循环循环准备替换掉所有分类的id，全部转换为名字
        for (ToyCreateidea toyCreateidea:list) {
            ToyCreateideaAll all=new ToyCreateideaAll();

            for (ToyClassification t:type) {
                if(toyCreateidea.getCiKind().equals(t.getcId())){
                    all.setKindname(t.getcName());
                }
                if(toyCreateidea.getCiAgegroup().equals(t.getcId())){
                    all.setAgename(t.getcName()+"岁");
                }
                if(toyCreateidea.getCiTexture().equals(t.getcId())){
                    all.setTexturename(t.getcName());
                }
                if(toyCreateidea.getCiFunction().equals(t.getcId())){
                    all.setFunctionname(t.getcName());
                }
            }
            all.setCiId(toyCreateidea.getCiId());
            all.setCiAction(toyCreateidea.getCiAction());

            all.setCiUserid(toyCreateidea.getToyUser().getuId());
            all.setCiUsername(toyCreateidea.getToyUser().getuName());
            all.setCiUserusername(toyCreateidea.getToyUser().getuUsername());
            all.setCiUserimg(toyCreateidea.getToyUser().getuHead());
            all.setCiState(toyCreateidea.getCiState());
            all.setCiPubtime(toyCreateidea.getCiPubtime());
            all.setCiMark(toyCreateidea.getCiMark());
            all.setCiScan(toyCreateidea.getCiScan());
            all.setCiTitle(toyCreateidea.getCiTitle());
            all.setCiContent(toyCreateidea.getCiContent());
            all.setCiImg(toyCreateidea.getCiImg());
            listall.add(all);

        }
        return listall;
    }

    @Override
    public List<ToyCreateidea> selectbyuser(Integer userid) {
        return toyCreateideaMapper.selectbyuser(userid);
    }
}
