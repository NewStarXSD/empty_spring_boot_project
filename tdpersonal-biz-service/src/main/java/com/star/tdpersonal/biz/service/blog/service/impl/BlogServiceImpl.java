package com.star.tdpersonal.biz.service.blog.service.impl;

import com.star.tdpersonal.biz.manager.blog.BlogManager;
import com.star.tdpersonal.biz.service.blog.service.BlogService;
import com.star.tdpersonal.common.dal.elastic.blog.condition.BlogESCondition;
import com.star.tdpersonal.common.dal.elastic.blog.entity.BlogESDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tdpersonal
 * @description: 博客业务逻辑服务实现
 * @author: xinsida
 * @create: 2021-06-27 16:17
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogManager blogManager;

    @Override
    public List<BlogESDO> queryBlogList(BlogESCondition blogESCondition) {
        return blogManager.queryBlogList(blogESCondition);
    }

}
