package com.example.Query.Controller;

import com.example.Query.Dto.Search;
import com.example.Query.Entity.CaseDetails;
import com.example.Query.Service.CaseDetailsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/caseDetails")
public class CaseDetailsController {

    private final CaseDetailsService caseDetailsService;

    public CaseDetailsController(CaseDetailsService caseDetailsService) {
        this.caseDetailsService = caseDetailsService;
    }

//    @GetMapping("/get")
//    public ResponseEntity<Map<String, Object>> getCaseDetails(@RequestParam String activityLevel){
//        try{
//
//            Map<String,Object> res = caseDetailsService.getCaseDetails(activityLevel);
//            return new ResponseEntity<>(res,HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }

       @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getCaseDetails(@RequestParam String activityLevel){
        try{

            Map<String,Object> res = caseDetailsService.getCaseDetails(activityLevel);
            return new ResponseEntity<>(res,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to added", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadExcel(@RequestParam String activityLevel) {
        try {
            Map<String, Object> res = caseDetailsService.getCaseDetails(activityLevel);

            // Convert the data to Excel format
            byte[] excelFile = caseDetailsService.createExcelFile(res);

            // Set the content type and headers for Excel file download
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=CaseDetails" + activityLevel + ".xlsx");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(excelFile);

        } catch (Exception e) {
            throw new RuntimeException("Error generating Excel file", e);
        }
    }




    @GetMapping("/search")
    public ResponseEntity<Map<String,Object>> search(@RequestBody Search search) {
        try {
            Map<String, Object> res = caseDetailsService.search(search);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Failed to search", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }




//    @GetMapping("/search")
//    public ResponseEntity<Map<String,Object>> search(@RequestParam(required = false) Long caseRefNo, @RequestParam(required = false) String groupName, @RequestParam(required = false)  String divisionName,
//                                                     @RequestParam(required = false) String activityLevel, @RequestParam(required = false) String status,
//                                                     @RequestParam(required = false) String assignedTo, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdDate,
//                                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime updatedDate,
//                                                     @RequestParam(required = false) String planing, @RequestParam(required = false) String fieldWork){
//        try{
//            Map<String,Object> res = caseDetailsService.search(caseRefNo,groupName,divisionName,activityLevel,status,assignedTo,createdDate,updatedDate,planing,fieldWork);
//            return new ResponseEntity<>(res,HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(Map.of("message", "Failed to search", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
//        }









    }



