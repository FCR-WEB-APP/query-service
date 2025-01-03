package com.example.Query.Controller;


import com.example.Query.Entity.Obligour;
import com.example.Query.Service.ObligourService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obligour")
public class ObligourController {

    private final ObligourService obligourService;

    public ObligourController(ObligourService obligourService){
        this.obligourService=obligourService;
    }

    @GetMapping("/get")
    public Obligour getObligour(@RequestParam Long obligourId){
        return obligourService.getObligour(obligourId);
    }

}
