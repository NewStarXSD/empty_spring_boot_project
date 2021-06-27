package com.star.tdpersonal.web.controller;


import com.star.tdpersonal.biz.service.blog.service.BlogService;
import com.star.tdpersonal.common.dal.elastic.blog.condition.BlogESCondition;
import com.star.tdpersonal.common.dal.elastic.blog.entity.BlogESDO;
import com.star.tdpersonal.common.util.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tdpersonal
 * @description: 博客控制器
 * @author: xinsida
 * @create: 2021-06-26 17:21
 **/
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/queryBlog")
    public ResultVO<List<BlogESDO>> queryBlog(BlogESCondition blogESCondition) {
        return ResultVO.succeed(blogService.queryBlogList(blogESCondition));
    }

}
