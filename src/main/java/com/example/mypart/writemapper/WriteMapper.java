package com.example.mypart.writemapper;

import com.example.mypart.writecontroller.PostImg;
import com.example.mypart.writecontroller.PostImgDAO;
import com.example.mypart.writecontroller.PostModel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface WriteMapper {
    int insPost(PostModel param);
    int insPostImg(PostImg param);
}
