package com.example.Query.Service;

import com.example.Query.Dao.UploadDao;
import com.example.Query.Entity.Upload;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UploadService {
    private final UploadDao uploadDao;

    public UploadService(UploadDao uploadDao) {
        this.uploadDao = uploadDao;
    }


    public Map<String, Object> getUploadList(Long caseRefNo) {
        List<Upload>ls = uploadDao.getUploadList(caseRefNo);
        return Map.of(
                "status", HttpStatus.OK.value(),
                "message","successfully get",
                "data",ls
        );
    }
}
