package com.admin.admin.service.impl;

import com.admin.admin.pojo.ToyCreateideaAll;
import com.admin.admin.pojo.ToyMessage;
import com.admin.admin.service.QueryService;
import com.admin.admin.service.ToyCreateIdeaService;
import com.admin.admin.service.ToyMessageService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @anther fgy
 * @title
 * @time 2019-9-13 13:22
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private SolrClient solrServer;

    @Autowired
    private ToyCreateIdeaService toyCreateIdeaService;
    @Override
    public void delete() {
        try {
            solrServer.deleteByQuery("*:*");
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        List<ToyCreateideaAll> list=toyCreateIdeaService.selectAll();
        try {
                for (ToyCreateideaAll toyCreateideaAll:list) {
                        SolrInputDocument document = new SolrInputDocument ();
                        document.addField("id",toyCreateideaAll.getCiId());
                        document.addField("toy_img",toyCreateideaAll.getCiImg());
                        document.addField("toy_title",toyCreateideaAll.getCiTitle());
                        document.addField("toy_content",toyCreateideaAll.getCiContent());
                        document.addField("toy_scan",toyCreateideaAll.getCiScan());
                        document.addField("toy_age",toyCreateideaAll.getAgename());
                        document.addField("toy_kind",toyCreateideaAll.getKindname());
                        document.addField("toy_texture",toyCreateideaAll.getTexturename());
                        document.addField("toy_function",toyCreateideaAll.getFunctionname());
                        document.addField("toy_userid",toyCreateideaAll.getCiUserid());
                        document.addField("toy_username",toyCreateideaAll.getCiUsername());
                        document.addField("toy_userimg",toyCreateideaAll.getCiUserimg());

                    solrServer.add(document);
                        }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
