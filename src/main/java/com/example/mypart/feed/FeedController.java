package com.example.mypart.feed;

import com.example.mypart.writecontroller.PostModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/feed")
public class FeedController {
    @Autowired
    FeedService feedService;

    @RequestMapping("/myfeedlist")
    public String myFeedList(){
        return "/map/myFeed";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<PostModelDAO> feedList(@RequestParam("iuser") int iuser, @RequestParam("limit") int limit,@RequestParam("page") int page){
        PostModelDAO postModelDAO=new PostModelDAO();
        postModelDAO.setIuser(iuser);
        postModelDAO.setStartPage((page-1)*limit);
        List<PostModelDAO> list=feedService.selMyFeedList1(postModelDAO);
        return list;
    }

    @ResponseBody
    @RequestMapping("/myfeedpage")
    public int myFeedPage(@RequestParam("iuser") int iuser, @RequestParam("limit") int limit){
        PostModelDAO postModelDAO=new PostModelDAO();
        postModelDAO.setIuser(iuser);
        postModelDAO.setLimit(limit);
        return feedService.selFeedPage(postModelDAO);
    }
}
