package com.star.tdpersonal.biz.manager.blog;

import com.star.tdpersonal.common.dal.elastic.blog.condition.BlogESCondition;
import com.star.tdpersonal.common.dal.elastic.blog.entity.BlogESDO;

import java.util.List;

/**
 * @program: tdpersonal
 * @description: 博客通用业务处理接口
 * @author: xinsida
 * @create: 2021-06-26 19:22
 **/
public interface BlogManager {

    /**
     * 搜索博客
     *
     * @param blogESCondition
     * @return
     */
    List<BlogESDO> queryBlogList(BlogESCondition blogESCondition);

}
