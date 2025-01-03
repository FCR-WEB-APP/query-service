package com.example.Query.Service;

 import com.example.Query.Entity.IssueDetails;
 import com.example.Query.Dao.IssueDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueDetailsService {
    @Autowired
    private IssueDetailsDAO issueDetailsDAO;


    public IssueDetails getIssueDetailsById(int issueId) {
         return issueDetailsDAO.getIssueDetailsById(issueId);
    }
}

