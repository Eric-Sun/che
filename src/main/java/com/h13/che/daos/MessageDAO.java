package com.h13.che.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午1:55
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MessageDAO {

    @Autowired
    JdbcTemplate j;

    public void add(String uid,String content){
        String sql = "insert into message (uid,content,createtime) values(?,?,now())";
        j.update(sql,new Object[]{uid,content});
    }
}
