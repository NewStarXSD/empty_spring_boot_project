package com.star.tdpersonal.common.dal.blog.mapper.single.mysql;

import com.star.tdpersonal.common.dal.blog.entity.BlogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: tdpersonal
 * @Description: 博客Mapper
 * @author: xinsida
 * @create: 2021-06-15 18:12
 **/
@Mapper
public interface BlogMapper {

    /**
     * 新增博客
     *
     * @param blogDO
     * @return
     */
    int insert(BlogDO blogDO);

}
