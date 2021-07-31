package com.example.mypart.search.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchDAO {
    private int searchType;
    private int startPage;
    private String searchWord;
    private int limit;
}
