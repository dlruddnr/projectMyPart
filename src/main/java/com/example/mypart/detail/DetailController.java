package com.example.mypart.detail;

import com.example.mypart.detail.model.CmtDAO;
import com.example.mypart.detail.model.PostFavEntity;
import com.example.mypart.writecontroller.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired private DetailService service;

    @PostMapping("/delPost")
    public String delPost(PostModel param, Model model){
        int result=service.delPost(param);
        if(result==0){
            String errMsg="삭제가 되지 않았습니다";
            model.addAttribute("errMsg",errMsg);
        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/cmtLoad")
    public List<CmtDAO> cmtList(@RequestParam("iboard") int iboard){
        System.out.println(iboard);
        List<CmtDAO> cmtList=service.selComList(iboard);
        return cmtList;
    }

    @ResponseBody
    @PostMapping("/cmtUpload")
    public int cmtUpload(@RequestBody CmtDAO param){
        int result=service.insCmt(param);
        return result;
    }

    @ResponseBody
    @PostMapping("/cmtDel")
    public int cmtDel(@RequestBody CmtDAO param){
        System.out.println(param);
        return service.delCmt(param);
    }

    @ResponseBody
    @PostMapping("/insFav")
    public int insFav(@RequestBody PostFavEntity param){
        System.out.println("업데이트"+service.updFav(param));
        int result=service.insFav(param);
        service.updFav(param);
        return result;
    }

    @ResponseBody
    @PostMapping("/delFav")
    public int delFav(@RequestBody PostFavEntity param){
        System.out.println("업데이트"+service.updFav(param));
        int result=service.delFav(param);
        service.updFav(param);
        return result;
    }

}
