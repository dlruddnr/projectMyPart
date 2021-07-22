package com.example.mypart.writecontroller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class PostImg {
    private int iboardIMG;
    private int iboard;
    private String img_addr;
}
