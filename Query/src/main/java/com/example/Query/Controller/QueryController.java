package com.example.Query.Controller;



import com.example.Query.Entity.Query;
import com.example.Query.Service.QueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/query")
public class QueryController {
    private final QueryService queryService;

    public QueryController(QueryService queryService){
        this.queryService=queryService;
    }

    @GetMapping("/get")
    public Query getQuery(@RequestParam Long queryId){
        return queryService.getQuery(queryId);
    }


}
