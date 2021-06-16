package com.star.tdpersonal.biz.manager.blog;

import com.star.tdpersonal.biz.manager.blog.converter.BlogConverter;
import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;
import com.star.tdpersonal.common.dal.blog.entity.BlogDO;
import com.star.tdpersonal.common.dal.blog.mapper.single.mysql.BlogMapper;
import com.star.tdpersonal.common.util.common.LoggerNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: tdpersonal
 * @description: 博客通用业务处理层
 * @author: xinsida
 * @create: 2021-06-15 21:01
 **/
@Component
@Slf4j(topic = LoggerNames.MANAGER)
public class BlogManager {

    @Resource
    private BlogMapper blogMapper;

    /**
     * 新增博客
     * @param blogDTO
     * @return
     */
    public boolean createBlog(BlogDTO blogDTO){
        log.info("in@BlogManager createBlog blogDTO = {}", blogDTO);
        BlogDO blogDO = BlogConverter.convertDTO2DO(blogDTO);
        int lines = blogMapper.insert(blogDO);
        log.info("out@BlogManager createBlog lines = {}", lines);
        if(lines == 0){
            return false;
        }
        return true;
    }

}
