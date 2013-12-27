package com.h13.che.services;

import com.h13.che.cache.co.CommentCO;
import com.h13.che.cache.service.CommentCache;
import com.h13.che.controllers.CommentController;
import com.h13.che.daos.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CommentService {

    @Autowired
    CommentDAO commentDAO;
    @Autowired
    CommentCache commentCache;

    public void add(String uid,long mid,String content){
        long cid = commentDAO.add(uid,mid,content);
        CommentCO commentCO = new CommentCO();
        commentCO.setId(cid);
        commentCO.setContent(content);
        commentCO.setTs(System.currentTimeMillis());
        commentCO.setMid(mid);
        commentCO.setUid(uid);
        commentCache.put(commentCO);
    }

    public List<CommentCO> get(String uid,long mid){
        List<CommentCO> list = commentCache.get(mid);
        if(list==null){
            // load from db
            list = commentDAO.getAll(mid);
            commentCache.putAll(mid,list);
        }
        return list;
    }
}
