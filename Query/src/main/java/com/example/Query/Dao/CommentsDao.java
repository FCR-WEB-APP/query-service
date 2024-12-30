package com.example.Query.Dao;

import com.example.Query.Entity.Comments;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDao {

    private final JdbcTemplate jdbcTemplate1;


    public CommentsDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public List<Comments> getAll() {
        String sql = "select * from comments";
        return jdbcTemplate1.query(sql,new BeanPropertyRowMapper<>(Comments.class));
    }
}
