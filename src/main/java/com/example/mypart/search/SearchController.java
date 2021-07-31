package com.example.mypart.search;

import com.example.mypart.feed.FeedService;
import com.example.mypart.search.model.SearchDAO;
import com.example.mypart.writecontroller.PostModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;
    @Autowired
    FeedService feedService;

    @RequestMapping("/window")
    public String window(){
        return "map/searchWindow";
    }

    @RequestMapping("/result")
    public String result(SearchDAO param, Model model){
        System.out.println(param);
        model.addAttribute("search",param);
        model.addAttribute("pageNum",feedService.selFeedPage3(param));
        return "map/searchFeed";
    }

    @ResponseBody
    @RequestMapping("/feedlist")
    public List<PostModelDAO> feedList(@RequestParam("searchWord") String searchWord, @RequestParam("searchType") int searchType,
                                       @RequestParam("limit") int limit, @RequestParam("page") int page){
        SearchDAO searchDAO=new SearchDAO();
        searchDAO.setSearchWord(searchWord);
        searchDAO.setSearchType(searchType);
        searchDAO.setStartPage((page-1)*limit);
        return searchService.selSearchResult(searchDAO);
    }

    @ResponseBody
    @RequestMapping("/page")
    public int searchPage(@RequestParam("searchWord") String searchWord, @RequestParam("searchType") int searchType,
                                       @RequestParam("limit") int limit){
        SearchDAO searchDAO=new SearchDAO();
        searchDAO.setSearchWord(searchWord);
        searchDAO.setSearchType(searchType);
        searchDAO.setLimit(limit);
        return feedService.selFeedPage3(searchDAO);
    }

}
