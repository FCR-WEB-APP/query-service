package com.example.Query.Controller;

import com.example.Query.Service.UploadFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {

    private final UploadFileService uploadFileService;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @GetMapping("/get/{upload_File_Id}")

    public ResponseEntity<Map<String,Object>> getUploadFileRecord(@PathVariable("upload_File_Id") Long uploadFileId){
        try{
            Map<String,Object> res = uploadFileService.getUploadFileRecord(uploadFileId);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","unable to fetch","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
