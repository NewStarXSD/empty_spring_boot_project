package com.star.tdpersonal.biz.service.blog.service.impl;

import com.google.common.base.Preconditions;
import com.star.tdpersonal.biz.manager.blog.BlogManager;
import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;
import com.star.tdpersonal.biz.service.blog.service.BlogService;
import com.star.tdpersonal.common.util.constants.ServiceMessageConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: tdpersonal
 * @description: 博客业务逻辑服务层
 * @author: xinsida
 * @create: 2021-06-15 22:24
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogManager blogManager;

    @Override
    public Boolean createBlog(BlogDTO blogDTO) {
        Preconditions.checkArgument(null != blogDTO, ServiceMessageConstants.PARAM_IS_NULL, "blogDTO");
        return blogManager.createBlog(blogDTO);
    }

}
