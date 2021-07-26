package com.example.mypart.detail;

import com.example.mypart.detail.model.CmtDAO;
import com.example.mypart.detail.model.PostFavEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailMapper mapper;

    public List<CmtDAO> selComList(int iboard){
        if(iboard==0){
            return null;
        }
        List<CmtDAO> cmtDAOList=mapper.selComList(iboard);
        return cmtDAOList;
    }

    public int insCmt(CmtDAO param){
        int result=mapper.insCmt(param);
        return result;
    }

    public int delCmt(CmtDAO param){
        return mapper.delCmt(param);
    }

    public int insFav(PostFavEntity param){
        return mapper.insFav(param);
    }

    public int delFav(PostFavEntity param){ return mapper.delFav(param);}

    public int updFav(PostFavEntity param){ return mapper.updFav(param);}
}
