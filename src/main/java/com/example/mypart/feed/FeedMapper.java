package com.example.mypart.feed;

import com.example.mypart.writecontroller.PostModelDAO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FeedMapper {

    List<PostModelDAO> selMyFeedList(PostModelDAO param);
    List<PostModelDAO> selLikeFeedList(PostModelDAO param);
    List<PostModelDAO> selFavList(PostModelDAO param);

    int selFeedPage1(PostModelDAO param);
    int selFeedPage2(PostModelDAO param);
}
