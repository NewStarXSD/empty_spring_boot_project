package com.star.tdpersonal.biz.manager.blog.impl;

import com.star.tdpersonal.biz.manager.blog.BlogManager;
import com.star.tdpersonal.common.dal.elastic.blog.condition.BlogESCondition;
import com.star.tdpersonal.common.dal.elastic.blog.entity.BlogESDO;
import com.star.tdpersonal.common.dal.elastic.blog.mapper.single.BlogMapper;
import com.star.tdpersonal.common.util.common.LoggerNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tdpersonal
 * @description: 测试通用业务处理层
 * @author: xinsida
 * @create: 2021-06-15 21:01
 **/
@Component
@Slf4j(topic = LoggerNames.MANAGER)
public class BlogManagerImpl implements BlogManager {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<BlogESDO> queryBlogList(BlogESCondition blogESCondition) {
        return blogMapper.queryBlogList(blogESCondition);
    }

}
