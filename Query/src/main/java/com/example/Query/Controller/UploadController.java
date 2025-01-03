package com.example.Query.Controller;

import com.example.Query.Service.UploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/get/{case_Ref_No}")
    public ResponseEntity<Map<String,Object>> getUploadList(@PathVariable("case_Ref_No") Long caseRefNo){
        try{
            Map<String,Object> res = uploadService.getUploadList(caseRefNo);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","unable to fetch","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
