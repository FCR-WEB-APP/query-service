package com.example.Query.Controller;

import com.example.Query.Service.CaseDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/caseDetails")
public class CaseDetailsController {

    private final CaseDetailsService caseDetailsService;

    public CaseDetailsController(CaseDetailsService caseDetailsService) {
        this.caseDetailsService = caseDetailsService;
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getCaseDetails(@RequestParam String activityLevel){
        try{
            Map<String,Object> res = caseDetailsService.getCaseDetails(activityLevel);
            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
