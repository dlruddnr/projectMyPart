package com.example.mypart.writecontroller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostModelDAO extends PostModel{
    private String img_addr;
    private String writer;
    private int userIuser;
    private int countFav;
}
