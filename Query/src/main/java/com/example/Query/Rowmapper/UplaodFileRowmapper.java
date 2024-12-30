package com.example.Query.Rowmapper;

import com.example.Query.Entity.UploadFile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class UplaodFileRowmapper implements RowMapper<UploadFile> {
    @Override
    public UploadFile mapRow(ResultSet rs, int rowNum) throws SQLException {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setUploadFileId(rs.getLong("upload_File_Id"));
        uploadFile.setFileContent(rs.getBytes("file_Content"));
        uploadFile.setFileName(rs.getString("file_Name"));
        return uploadFile;
    }
}
