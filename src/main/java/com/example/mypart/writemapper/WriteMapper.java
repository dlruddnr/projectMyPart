package com.example.mypart.writemapper;

import com.example.mypart.writecontroller.PostImg;
import com.example.mypart.writecontroller.PostImgDAO;
import com.example.mypart.writecontroller.PostModel;
import com.example.mypart.writecontroller.PostModelDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface WriteMapper {
    int insPost(PostModel param);
    int insPostImg(PostImg param);

    List<PostModelDAO> selDetail(int iboard);
}
