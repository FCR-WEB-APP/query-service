package com.example.Query.Dao;

import com.example.Query.Entity.UploadFile;
import com.example.Query.Rowmapper.UplaodFileRowmapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Base64;

@Repository
public class UploadFileDao {

    private final JdbcTemplate jdbcTemplate1;

    public UploadFileDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


    public UploadFile getUploadFileRecord(Long uploadFileId) {

        String sql = "select * from uploadfile where upload_File_Id = ?";
        return jdbcTemplate1.queryForObject(sql,new Object[]{uploadFileId},new UplaodFileRowmapper());

//        return jdbcTemplate1.queryForObject(sql, new Object[]{uploadFileId}, (rs, rowNum) -> {
//            UploadFile uploadFile = new UploadFile();
//            uploadFile.setUploadFileId(uploadFileId);
//            uploadFile.setFileContent(rs.getBytes("file_Content"));
//            uploadFile.setFileName(rs.getString("file_Name"));
//            return uploadFile;
//
//        });

    }

}
