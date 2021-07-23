package com.example.mypart.detail;

import com.example.mypart.detail.model.CmtDAO;
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
}
