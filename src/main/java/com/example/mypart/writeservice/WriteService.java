package com.example.mypart.writeservice;

import com.example.mypart.common.FileUtils;
import com.example.mypart.writecontroller.PostImg;
import com.example.mypart.writecontroller.PostImgDAO;
import com.example.mypart.writecontroller.PostModel;
import com.example.mypart.writecontroller.PostModelDAO;
import com.example.mypart.writemapper.WriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class WriteService {
    @Autowired
    private WriteMapper mapper;
    @Autowired
    private FileUtils fileUtils;

    public int insPost(PostModel param){
        return mapper.insPost(param);
    }

    public int insPostImg(PostImgDAO param){
        if(param.getFiles()==null && param.getIboard()==0){
            return 0;
        }
        PostImg postImg=new PostImg();
        postImg.setIboard(param.getIboard());
        for(MultipartFile img: param.getFiles()){
            String saveFileNm=fileUtils.transferTo(img,"post/"+param.getIboard());
            postImg.setImg_addr(saveFileNm);
            if(saveFileNm!=null){
                mapper.insPostImg(postImg);
            }
        }
        return 0;
    }

    public List<PostModelDAO> selDetail(int iboard){
        return mapper.selDetail(iboard);
    }
}
