package com.example.mypart.detail.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostFavEntity {
    private int iboard;
    private int iuser;
    private String regdt;
    private int selCntFav;
}
