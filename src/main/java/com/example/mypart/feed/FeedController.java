package com.example.mypart.feed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/feed")
public class FeedController {

    @RequestMapping("/test")
    public String test1(Model model){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        model.addAttribute("list",list);
        return "map/feedList";
    }
}
