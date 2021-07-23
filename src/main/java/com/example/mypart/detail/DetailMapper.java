package com.example.mypart.detail;

import com.example.mypart.detail.model.CmtDAO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DetailMapper {
    List<CmtDAO> selComList(int iboard);
    int insCmt(CmtDAO param);
}
