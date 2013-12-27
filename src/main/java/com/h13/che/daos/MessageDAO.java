package com.h13.che.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public long add(final String uid,final String content){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into message (uid,content,createtime) values(?,?,now())";
        j.update(sql,new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1,uid);
                pstmt.setString(2,content);
                return pstmt;
            }
        },keyHolder);
        return keyHolder.getKey().longValue();
    }

}
