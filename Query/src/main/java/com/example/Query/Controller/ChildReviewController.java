package com.example.Query.Controller;


import com.example.Query.Entity.ChildReview;
import com.example.Query.Service.ChildReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/childReview")
public class ChildReviewController {
    private final ChildReviewService childReviewService;

    public ChildReviewController(ChildReviewService childReviewService){
        this.childReviewService=childReviewService;
    }

    @GetMapping("/get")
    public ChildReview getChildReview(@RequestParam Long childId){
        return childReviewService.getChildReview(childId);
    }
}
