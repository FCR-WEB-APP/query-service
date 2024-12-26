package com.example.Query.Dao;

import com.example.Query.Entity.CaseDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CaseDetailsDao {

    private final JdbcTemplate jdbcTemplate1;

    public CaseDetailsDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public List<CaseDetails> getCaseDetails(String activityLevel) {
        String sql = "select * from casedetails where activity_Level = ?";
        return jdbcTemplate1.query(sql,new BeanPropertyRowMapper<>(CaseDetails.class),activityLevel);

    }
}
