package com.example.Query.Dao;


import com.example.Query.Entity.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class QueryDao {
    private final JdbcTemplate jdbcTemplate1;

    public QueryDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public Query getQuery(Long queryId) {
        String sql = "Select * from Query Where Query_Id=?";
        return jdbcTemplate1.queryForObject(sql, new Object[]{queryId}, new QueryMapper());
    }

    public class QueryMapper implements RowMapper<Query> {
        @Override
        public Query mapRow(ResultSet rs, int rowNum) throws SQLException {
            Query query=new Query();
            query.setQueryId(rs.getLong("Query_Id"));
            query.setChildId(rs.getLong("Child_Id"));
            query.setQueryDescription(rs.getString("Query_Description"));
            query.setResponse(rs.getString("Response"));
            return query;
        }
    }
}
