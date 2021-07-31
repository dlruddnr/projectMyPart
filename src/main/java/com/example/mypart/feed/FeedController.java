package com.example.mypart.feed;

import com.example.mypart.search.model.SearchDAO;
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
    @RequestMapping("/my")
    public List<PostModelDAO> feedList(@RequestParam("iuser") int iuser, @RequestParam("limit") int limit,@RequestParam("page") int page){
        PostModelDAO postModelDAO=new PostModelDAO();
        postModelDAO.setIuser(iuser);
        postModelDAO.setStartPage((page-1)*limit);
        List<PostModelDAO> list=feedService.selMyFeedList1(postModelDAO);
        return list;
    }

    @RequestMapping("/likefeedlist")
    public String likeFeedList(){
        return "/map/likeFeed";
    }

    @ResponseBody
    @RequestMapping("/like")
    public List<PostModelDAO> likeFeedList(@RequestParam("iuser") int iuser, @RequestParam("limit") int limit,@RequestParam("page") int page){
        PostModelDAO postModelDAO=new PostModelDAO();
        postModelDAO.setIuser(iuser);
        postModelDAO.setStartPage((page-1)*limit);
        List<PostModelDAO> list=feedService.selLikeFeedList(postModelDAO);
        return list;
    }

    @RequestMapping("/favfeedlist")
    public String favFeedList(){
        return "/map/favFeed";
    }

    @ResponseBody
    @RequestMapping("/fav")
    public List<PostModelDAO> favFeedList(@RequestParam("iuser") int iuser, @RequestParam("limit") int limit,@RequestParam("page") int page){
        PostModelDAO postModelDAO=new PostModelDAO();
        postModelDAO.setIuser(iuser);
        postModelDAO.setStartPage((page-1)*limit);
        List<PostModelDAO> list=feedService.selFavList(postModelDAO);
        return list;
    }



    @ResponseBody
    @RequestMapping("/myfeedpage")
    public int myFeedPage(@RequestParam("iuser") int iuser, @RequestParam("limit") int limit, @RequestParam("type") int type,
                          @RequestParam(value="searchType", required = false) int searchType, @RequestParam(value="searchWord", required = false) String searchWord){
        PostModelDAO postModelDAO=new PostModelDAO();
        postModelDAO.setIuser(iuser);
        postModelDAO.setLimit(limit);
        if(type==0){
            return feedService.selFeedPage1(postModelDAO);
        }
        return feedService.selFeedPage2(postModelDAO);
    }
}
