package com.example.Query.Dao;

import com.example.Query.Entity.Upload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UploadDao {

    private final JdbcTemplate jdbcTemplate1;

    public UploadDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public List<Upload> getUploadList(Long caseRefNo) {


        String sql = "select * from upload where case_Ref_No = ?";
        return jdbcTemplate1.query(sql,new BeanPropertyRowMapper<>(Upload.class),caseRefNo);


    }
}
