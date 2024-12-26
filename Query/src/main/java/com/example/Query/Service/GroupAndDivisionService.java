package com.example.Query.Service;

import com.example.Query.Dao.GroupAndDivisionDao;
import com.example.Query.Entity.GroupAndDivision;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupAndDivisionService {

    private final GroupAndDivisionDao groupAndDivisionDao;

    public GroupAndDivisionService(GroupAndDivisionDao groupAndDivisionDao) {
        this.groupAndDivisionDao = groupAndDivisionDao;
    }

    public Map<String, Object> getAll() {
        List<GroupAndDivision> res = groupAndDivisionDao.getAll();
        return Map.of(
                "status", HttpStatus.OK.value(),
                "success","successfully fetched",
                "data",res
        );
    }
}
