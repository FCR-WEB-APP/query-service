package com.example.Query.Dao;

import com.example.Query.Entity.GroupAndDivision;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupAndDivisionDao {

    private final JdbcTemplate jdbcTemplate1;

    public GroupAndDivisionDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public List<GroupAndDivision> getAll() {
        String sql = "select * from groupanddivision";
        return jdbcTemplate1.query(sql,new BeanPropertyRowMapper<>(GroupAndDivision.class));
    }
}
