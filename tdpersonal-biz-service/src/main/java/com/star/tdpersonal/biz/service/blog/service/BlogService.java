package com.star.tdpersonal.biz.service.blog.service;

import com.star.tdpersonal.common.dal.elastic.blog.condition.BlogESCondition;
import com.star.tdpersonal.common.dal.elastic.blog.entity.BlogESDO;

import java.util.List;

/**
 * @program: tdpersonal
 * @description: 博客业务逻辑服务层
 * @author: xinsida
 * @create: 2021-06-27 16:16
 **/
public interface BlogService {

    /**
     * 查询博客列表
     *
     * @param blogESCondition
     * @return
     */
    List<BlogESDO> queryBlogList(BlogESCondition blogESCondition);
}
