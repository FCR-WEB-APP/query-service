package com.example.Query.Controller;

import com.example.Query.Service.GroupAndDivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("grpAnddiv")
public class GroupAndDivisionController {

    private final GroupAndDivisionService groupAndDivisionService;


    public GroupAndDivisionController(GroupAndDivisionService groupAndDivisionService) {
        this.groupAndDivisionService = groupAndDivisionService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<String,Object>> getAll(){
        try{
            Map<String,Object> res = groupAndDivisionService.getAll();
            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Map.of("message","unable to fetch","error",e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
