package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.proterties.AliyunProterties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private User user;

    @GetMapping("/test")
    public String test(){
        return "Hello SpringBoot!";
    }

    @GetMapping("/user")
    public User user(){
        return user;
    }

    @Value("${picPath}")
    private String picPath;
    @GetMapping("/picPath")
    public String picPath(){
        return picPath;
    }

    @Autowired
    private AliyunProterties proterties;
    @GetMapping("/aliyun")
    public AliyunProterties aliyun(){
        return proterties;
    }

}
