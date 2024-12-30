package com.example.Query.Service;

import com.example.Query.Dao.UploadFileDao;
import com.example.Query.Entity.UploadFile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UploadFileService {

    private final UploadFileDao uploadFileDao;

    public UploadFileService(UploadFileDao uploadFileDao) {
        this.uploadFileDao = uploadFileDao;
    }

    public Map<String, Object> getUploadFileRecord(Long uploadFileId) {
        UploadFile uploadFile = uploadFileDao.getUploadFileRecord(uploadFileId);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "message","successfully get",
                "data",uploadFile
        );
    }
}
