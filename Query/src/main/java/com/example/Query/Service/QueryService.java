package com.example.Query.Service;


import com.example.Query.Dao.QueryDao;
import com.example.Query.Entity.Query;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    private final QueryDao queryDao;

    public QueryService(QueryDao queryDao) {
        this.queryDao = queryDao;
    }

    public Query getQuery(Long queryId){
        return queryDao.getQuery(queryId);
    }
}
