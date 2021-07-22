package com.example.mypart.writecontroller;

import com.example.mypart.writeservice.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/map")
public class Controlleras {
    @Autowired
    private WriteService writeService;

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
}
