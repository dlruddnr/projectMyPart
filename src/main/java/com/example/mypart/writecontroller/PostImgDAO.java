package com.example.mypart.writecontroller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@ToString
public class PostImgDAO extends PostImg{
    private MultipartFile[] files;
}
