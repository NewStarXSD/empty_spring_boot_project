package com.star.tdpersonal.biz.manager.blog.converter;

import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;
import com.star.tdpersonal.common.dal.blog.entity.BlogDO;

/**
 * @program: tdpersonal
 * @description: 博客传输类与实体类转换器
 * @author: xinsida
 * @create: 2021-06-15 22:16
 **/
public class BlogConverter {

    public static BlogDTO convertDO2DTO(BlogDO blogDO) {
        if (null == blogDO) {
            return null;
        }
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setGmtCreate(blogDO.getGmtCreate());
        blogDTO.setTitle(blogDO.getTitle());
        blogDTO.setContent(blogDO.getContent());
        blogDTO.setGmtModified(blogDO.getGmtModified());
        blogDTO.setId(blogDO.getId());
        return blogDTO;
    }

    public static BlogDO convertDTO2DO(BlogDTO blogDTO) {
        if (null == blogDTO) {
            return null;
        }
        BlogDO blogDO = new BlogDO();
        blogDO.setContent(blogDTO.getContent());
        blogDO.setTitle(blogDTO.getTitle());
        blogDO.setGmtCreate(blogDTO.getGmtCreate());
        blogDO.setGmtModified(blogDTO.getGmtModified());
        blogDO.setId(blogDTO.getId());
        return blogDO;
    }

}
