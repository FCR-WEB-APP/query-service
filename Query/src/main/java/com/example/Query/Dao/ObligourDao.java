package com.example.Query.Dao;


import com.example.Query.Entity.Obligour;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ObligourDao {
    private final JdbcTemplate jdbcTemplate1;

    public ObligourDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public Obligour getObligour(Long obligourId){
        String sql="select * from Obligour where OBLIGOUR_ID=?";
        return jdbcTemplate1.queryForObject(sql,new Object[]{obligourId},new ObligourMapper());
    }
    public class ObligourMapper implements RowMapper<Obligour> {
        @Override
        public Obligour mapRow(ResultSet rs, int rowNum) throws SQLException {
            Obligour obligour=new Obligour();
            obligour.setObligourId(rs.getLong("OBLIGOUR_ID"));
            obligour.setCaseRefNo(rs.getLong("CASE_REF_NO"));
            obligour.setCifId(rs.getLong("CIF_ID"));
            obligour.setPremId(rs.getLong("PREM_ID"));
            obligour.setDivisionName(rs.getString("DIVISION_NAME"));
            obligour.setAssignTo(rs.getString("Assign_To"));
            obligour.setStatus(rs.getString("Status"));
            obligour.setCreatedDate(rs.getTimestamp("created_Date").toLocalDateTime());
            obligour.setUpdatedDate(rs.getTimestamp("Updated_Date").toLocalDateTime());
            return obligour;
        }
    }
}
