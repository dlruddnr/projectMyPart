package com.example.mypart.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
public class FileUtils {
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    //저장 폴더 생성
    public void mkFolders(String path){
        File file=new File(path);
        file.mkdirs();
    }

    public String getSavePath(String path){
        return uploadPath+"/"+path;  //uploadPath/path
    }

    public String getRandomFileNm(){
        return UUID.randomUUID().toString();
    }

    public String getRandomFileNm(String originFileNm) {
        return getRandomFileNm() + "." + getExt(originFileNm);
        //return "aslkdfjaslkf2130asdwds" + "." + "jpg"
        //return "aslkdfjaslkf2130asdwds.jpg"
    }

    //랜덤 파일명 만들기
    public String getRandomFileNm(MultipartFile file) {
        return getRandomFileNm(file.getOriginalFilename());
    }

    //확장자 얻기             aaa.jpg"
    public String getExt(String fileNm) {
        return fileNm.substring(fileNm.lastIndexOf(".") + 1);
    }

    //파일 저장 & 랜덤파일명 리턴                  target = "profile/10"
    public String transferTo(MultipartFile mf, String target) {
        String fileNm = getRandomFileNm(mf); //"aslkdfjaslkf2130asdwds.jpg"  UUID+확장자명
        String basePath = getSavePath(target); //이미지를 저장할 절대경로값을 만든다. "D:/springImg/profile/10" //uploadPath/path
        System.out.println("filenm:"+fileNm);
        System.out.println("basePath:"+basePath);
        mkFolders(basePath); //(폴더가 없을 수 있기 때문에)폴더를 만들어준다.
        File saveFile = new File(basePath, fileNm);

        try {
            mf.transferTo(saveFile);
            return fileNm;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
