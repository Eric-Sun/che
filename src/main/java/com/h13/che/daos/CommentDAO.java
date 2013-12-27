package com.h13.che.daos;

import com.h13.che.cache.co.CommentCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-12-17
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CommentDAO {

    @Autowired
    JdbcTemplate j;

    public long add(final String uid, final long mid, final String content) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into comment (uid,mid,content,createtime) values (?,?,?,now())";
        j.update(sql, new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, uid);
                pstmt.setLong(2, mid);
                pstmt.setString(3, content);
                return pstmt;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }


    public List<CommentCO> getAll(long mid) {
        String sql = "select * from comment where mid=?";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper<CommentCO>(CommentCO.class));
    }
}
