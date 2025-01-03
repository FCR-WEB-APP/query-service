package com.example.Query.Dao;


import com.example.Query.Entity.ChildReview;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ChildReviewDao {

    private final JdbcTemplate jdbcTemplate1;

    public ChildReviewDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }
    public ChildReview getChildReview(Long childId){
        String sql="SELECT * FROM Child_Review WHERE Child_Id=? ";
        return jdbcTemplate1.queryForObject(sql,new Object[]{childId},new ChildReviewMapper());
    }
    public class ChildReviewMapper implements RowMapper<ChildReview> {
        @Override
        public ChildReview mapRow(ResultSet rs, int rowNum) throws SQLException {
            ChildReview childReview=new ChildReview();
            childReview.setChildId(rs.getLong("Child_Id"));
            childReview.setObligourId(rs.getLong("Obligour_Id"));
            childReview.setAssignTo(rs.getString("Assign_To"));
            childReview.setCaseRefNo(rs.getString("Case_Ref_No"));
            childReview.setStatus(rs.getString("Status"));
            childReview.setCreatedBy(rs.getString("Created_By"));
            childReview.setUpdatedBy(rs.getString("Updated_By"));
            childReview.setCreatedDate(rs.getTimestamp("Created_Date").toLocalDateTime());
            childReview.setUpdatedDate(rs.getTimestamp("Updated_Date").toLocalDateTime());
            return childReview;
        }
    }
}
