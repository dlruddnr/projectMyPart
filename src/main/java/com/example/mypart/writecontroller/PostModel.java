package com.example.mypart.writecontroller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostModel {
    private int iboard;
    private int iuser;
    private String title;
    private String ctnt;
    private int region;
    private String place;
    private double location_Y;
    private double location_X;
    private int cntFav;
    private int season;
}
