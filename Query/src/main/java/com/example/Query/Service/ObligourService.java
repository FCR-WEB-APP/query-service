package com.example.Query.Service;


import com.example.Query.Dao.ObligourDao;
import com.example.Query.Entity.Obligour;
import org.springframework.stereotype.Service;

@Service
public class ObligourService {
    private final ObligourDao obligourDao;

    public ObligourService(ObligourDao obligourDao) {
        this.obligourDao = obligourDao;
    }

    public Obligour getObligour(Long obligourId){
        return obligourDao.getObligour(obligourId);
    }
}