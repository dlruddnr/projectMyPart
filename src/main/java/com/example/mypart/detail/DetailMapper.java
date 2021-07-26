package com.example.mypart.detail;

import com.example.mypart.detail.model.CmtDAO;
import com.example.mypart.detail.model.PostFavEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DetailMapper {
    List<CmtDAO> selComList(int iboard);
    int insCmt(CmtDAO param);
    int delCmt(CmtDAO param);
    int insFav(PostFavEntity param);
    int delFav(PostFavEntity param);
    int updFav(PostFavEntity param);
}
