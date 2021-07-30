package com.example.mypart.feed;

import com.example.mypart.writecontroller.PostModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedService {
    @Autowired
    FeedMapper feedMapper;

    public List<PostModelDAO> selMyFeedList1(PostModelDAO param){
        return feedMapper.selMyFeedList(param);
    }

    public List<PostModelDAO> selLikeFeedList(PostModelDAO param) { return feedMapper.selLikeFeedList(param);}

    public int selFeedPage1(PostModelDAO param){
        return feedMapper.selFeedPage1(param);
    }

    public int selFeedPage2(PostModelDAO param){
        return feedMapper.selFeedPage2(param);
    }
}
