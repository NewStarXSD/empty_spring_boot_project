package com.star.tdpersonal.controller;

import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;
import com.star.tdpersonal.biz.service.blog.service.BlogService;
import com.star.tdpersonal.nacos.TdPersonalNacosCommonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: tdpersonal
 * @description: 测试用控制器
 * @author: xinsida
 * @create: 2021-06-13 18:08
 **/
@Controller
public class TestController {

    @Resource
    private TdPersonalNacosCommonConfig tdPersonalNacosConfig;

    @Resource
    private BlogService blogService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return tdPersonalNacosConfig.getEnv();
    }

    @GetMapping("/testCreateBlog")
    @ResponseBody
    public String testCreateBlog() {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(1L);
        blogDTO.setContent("test");
        blogDTO.setTitle("testTitle");
        return "res:" + blogService.createBlog(blogDTO);
    }
}
