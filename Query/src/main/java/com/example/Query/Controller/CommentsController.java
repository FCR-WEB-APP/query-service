package com.example.Query.Controller;

import com.example.Query.Service.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAll(){
        try{
            Map<String,Object> res = commentsService.getAll();
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","unable to procced","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
