package com.example.mypart.writecontroller;

import com.example.mypart.detail.DetailService;
import com.example.mypart.detail.model.PostFavEntity;
import com.example.mypart.writeservice.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@RequestMapping("/map")
public class Controlleras {
    @Autowired
    private WriteService writeService;
    @Autowired
    private DetailService detailService;

    @RequestMapping("/search")
    public String search(){
        return "map/search";
    }

    @RequestMapping("/write")
    public String write(){
        return "map/write";
    }

    @PostMapping("/write")
    public String write(@RequestParam("imgArr") MultipartFile[] imgArr , PostModel param){
        param.setIuser(1);
        PostImgDAO postImgDAO=new PostImgDAO();
        postImgDAO.setIboard(param.getIboard());
        postImgDAO.setFiles(imgArr);
        writeService.insPost(param);
        postImgDAO.setIboard(param.getIboard());
        writeService.insPostImg(postImgDAO);
        return null;
    }

    @PostMapping("/imgUplod")
    public String imgUpload(){

        return null;
    }

    @RequestMapping("/detail")
    public String detail(@RequestParam("iboard") int iboard, Model model){
        PostModelDAO param=new PostModelDAO();
        PostFavEntity postFavEntity=new PostFavEntity();
        postFavEntity.setIboard(iboard);
        detailService.updFav(postFavEntity);
        param.setIboard(iboard);
        List<PostModelDAO> result= writeService.selDetail(param);
        model.addAttribute("result",result);
        param.setUserIuser(1);
        model.addAttribute("chFav",writeService.chFav(param));
        return "map/detail";
    }


}
