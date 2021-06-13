package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: tdpersonal
 * @description
 * @author: xinsida
 * @create: 2021-06-13 18:08
 **/
@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "spring success";
    }
}
