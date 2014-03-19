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
 * Date: 14-3-19
 * Time: 下午4:22
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate j;


    public long loginByMobile(String mobile, String password) {
        final String sql = "select id from user where name=? and password=?";
        try {
            long id = j.queryForLong(sql, new Object[]{mobile, password});
            return id;
        } catch (Exception e) {
            return -1;
        }
    }

    public long register(final String mobile, final String password) {
        KeyHolder holder = new GeneratedKeyHolder();
        final String sql = "insert into user(name,password,registertime) values(?,?,now())";
        j.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, mobile);
                pstmt.setString(2, password);
                return pstmt;
            }
        }, holder);
        return holder.getKey().longValue();

    }
}
