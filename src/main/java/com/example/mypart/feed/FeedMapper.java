package com.example.mypart.feed;

import com.example.mypart.writecontroller.PostModelDAO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FeedMapper {

    List<PostModelDAO> selMyFeedList(PostModelDAO param);
    int selFeedPage(PostModelDAO param);
}
