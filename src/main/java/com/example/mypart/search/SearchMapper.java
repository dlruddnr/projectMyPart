package com.example.mypart.search;

import com.example.mypart.search.model.SearchDAO;
import com.example.mypart.writecontroller.PostModelDAO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SearchMapper {
    List<PostModelDAO> selSearchResult(SearchDAO param);
}
