package com.example.Query.Service;


import com.example.Query.Dao.ChildReviewDao;
import com.example.Query.Entity.ChildReview;
import org.springframework.stereotype.Service;

@Service
public class ChildReviewService {

    private final ChildReviewDao childReviewDao;

    public ChildReviewService(ChildReviewDao childReviewDao){
        this.childReviewDao=childReviewDao;
    }

    public ChildReview getChildReview(Long childId){
        return childReviewDao.getChildReview(childId);
    }

}
