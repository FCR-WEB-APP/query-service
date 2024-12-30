package com.example.Query.Service;

import com.example.Query.Dao.CommentsDao;
import com.example.Query.Entity.Comments;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentsService {

    private final CommentsDao commentsDao;

    public CommentsService(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }

    public Map<String, Object> getAll() {
        List<Comments> res = commentsDao.getAll();
        return Map.of(
                "status", HttpStatus.OK.value(),
                "message","successfully fetched",
                "data",res
        );
    }
}
