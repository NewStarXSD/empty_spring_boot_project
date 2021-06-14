package com.star.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.star.diamond.TdPersonalDiamondConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: tdpersonal
 * @description
 * @author: xinsida
 * @create: 2021-06-13 18:08
 **/
@Controller
public class TestController {

    @Resource
    private TdPersonalDiamondConfig tdPersonalDiamondConfig;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return tdPersonalDiamondConfig.getTestValue() + "spring success";
    }
}
