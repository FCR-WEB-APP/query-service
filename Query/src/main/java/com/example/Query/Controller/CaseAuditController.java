package com.example.Query.Controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/case-audits")
public class CaseAuditController {

    @Autowired
    private com.example.Query.Service.CaseAuditService caseAuditService;




    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllCaseAudits() {
        List<Map<String, Object>> caseAudits = caseAuditService.getAllCaseAudits();
        return ResponseEntity.ok(caseAudits);
    }

    /**
     * Get a specific case audit by case reference number.
     *
     * @param caseRefNo The case reference number.
     * @return The case audit details.
     */
    @GetMapping("/{caseRefNo}")
    public ResponseEntity<Map<String, Object>> getCaseAuditByCaseRefNo(@PathVariable String caseRefNo) {
        Map<String, Object> caseAudit = caseAuditService.getCaseAuditByCaseRefNo(caseRefNo);
        return ResponseEntity.ok(caseAudit);
    }
}
