package com.star.tdpersonal.biz.service.blog.service;

import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;

/**
 * @program: tdpersonal
 * @description: 博客业务逻辑服务层
 * @author: xinsida
 * @create: 2021-06-15 23:08
 **/
public interface BlogService {

    /**
     * 新建博客
     * @param blogDTO
     */
    Boolean createBlog(BlogDTO blogDTO);

}
