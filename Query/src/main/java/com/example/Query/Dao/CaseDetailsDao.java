package com.example.Query.Dao;

import com.example.Query.Dto.Search;
import com.example.Query.Entity.CaseDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
//    public CaseDetails search(Long caseRefNo, String groupName, String divisionName, String activityLevel,
//                              String status, String assignedTo, LocalDateTime createdDate, LocalDateTime updatedDate,
//                              String planing, String fieldWork) {

    public List<Search> search(Search search) {
        String sql = "SELECT * FROM casedetails WHERE 1 = 1";
        List<Object> params = new ArrayList<>();

        if (search.getCaseRefNo() != null) {
            sql += " AND case_ref_no = ?";
            params.add(search.getCaseRefNo());
        }
        if (search.getGroupName() != null && !search.getGroupName().isEmpty()) {
            sql += " AND group_Name = ?";
            params.add(search.getGroupName());
        }
        if (search.getDivisionName() != null && !search.getDivisionName().isEmpty()) {
            sql += " AND division_Name = ?";
            params.add(search.getDivisionName());
        }
        if (search.getActivityLevel() != null && !search.getActivityLevel().isEmpty()) {
            sql += " AND activity_Level = ?";
            params.add(search.getActivityLevel());
        }
        if (search.getStatus() != null && !search.getStatus().isEmpty()) {
            sql += " AND status = ?";
            params.add(search.getStatus());
        }
        if (search.getAssignedTo() != null && !search.getAssignedTo().isEmpty()) {
            sql += " AND assigned_To = ?";
            params.add(search.getAssignedTo());
        }
        if (search.getCreatedDate() != null) {
            sql += " AND created_Date = ?";
            params.add(search.getCreatedDate()/*.toLocalDate()*/);
        }
        if (search.getUpdatedDate() != null) {
            sql += " AND updated_Date = ?";
            params.add(search.getUpdatedDate()/*.toLocalDate()*/);
        }
        if (search.getPlaning() != null && !search.getPlaning().isEmpty()) {
            sql += " AND planing = ?";
            params.add(search.getPlaning());
        }
        if (search.getFieldWork() != null && !search.getFieldWork().isEmpty()) {
            sql += " AND field_Work = ?";
            params.add(search.getFieldWork());
        }

        try {
            return jdbcTemplate1.query(
                    sql,
                    new BeanPropertyRowMapper<>(Search.class),
                    params.toArray()
            );
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No records found for the given criteria.");
            return new ArrayList<>(); // Return an empty list instead of null
        }
    }









}
