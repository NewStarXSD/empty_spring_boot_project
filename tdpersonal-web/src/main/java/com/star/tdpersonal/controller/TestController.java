package com.star.tdpersonal.controller;

import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;
import com.star.tdpersonal.biz.service.blog.service.BlogService;
import com.star.tdpersonal.common.util.common.LoggerNames;
import com.star.tdpersonal.nacos.TdPersonalNacosCommonConfig;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j(topic = LoggerNames.CONTROLLER)
public class TestController {

    @Resource
    private TdPersonalNacosCommonConfig tdPersonalNacosConfig;

    @Resource
    private BlogService blogService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        log.info("in@TestController test time = {}", System.currentTimeMillis());
        return tdPersonalNacosConfig.getEnv();
    }

    @GetMapping("/testCreateBlog")
    @ResponseBody
    public String testCreateBlog() {
        log.info("in@TestController testCreateBlog time = {}", System.currentTimeMillis());
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(1L);
        blogDTO.setContent("test");
        blogDTO.setTitle("testTitle");
        return "res:" + blogService.createBlog(blogDTO);
    }
}
