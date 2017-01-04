package com.example.moudel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/11/18.
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String say(String string){
        return string;
    }
}
