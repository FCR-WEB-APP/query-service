package com.example.Query.Service;

import com.example.Query.Dao.CaseDetailsDao;
import com.example.Query.Entity.CaseDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CaseDetailsService {

    private final CaseDetailsDao caseDetailsDao;

    public CaseDetailsService(CaseDetailsDao caseDetailsDao) {
        this.caseDetailsDao = caseDetailsDao;
    }

    public Map<String, Object> getCaseDetails(String activityLevel) {
        List<CaseDetails> res = caseDetailsDao.getCaseDetails(activityLevel);
        return Map.of(
                "status" , HttpStatus.OK.value(),
                "success" , "successfully fetched",
                "data",res
        );
    }
}
