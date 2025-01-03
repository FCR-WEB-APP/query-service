package com.example.Query.Controller;
import com.example.Query.Entity.IssueDetails;
import com.example.Query.Service.IssueDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issue-details")
public class IssueDetailsController {

    private final IssueDetailsService issueDetailsService;

    @Autowired
    public IssueDetailsController(IssueDetailsService issueDetailsService) {
        this.issueDetailsService = issueDetailsService;
    }

    /**
     * API to get issue details by ID.
     *
     * @param issueId the ID of the issue to fetch
     * @return IssueDetails object wrapped in ResponseEntity
     */
    @GetMapping("/{issueId}")
    public ResponseEntity<IssueDetails> getIssueDetailsById(@PathVariable int issueId) {
        IssueDetails issueDetails = issueDetailsService.getIssueDetailsById(issueId);
        if (issueDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(issueDetails);
    }
}

