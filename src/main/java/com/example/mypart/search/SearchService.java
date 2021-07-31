package com.example.mypart.search;

import com.example.mypart.search.model.SearchDAO;
import com.example.mypart.writecontroller.PostModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchMapper searchMapper;

    public List<PostModelDAO> selSearchResult(SearchDAO param){
        return searchMapper.selSearchResult(param);
    }

}
