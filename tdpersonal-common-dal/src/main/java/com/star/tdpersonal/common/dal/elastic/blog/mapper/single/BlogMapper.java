package com.star.tdpersonal.common.dal.elastic.blog.mapper.single;

import com.star.tdpersonal.common.dal.elastic.blog.condition.BlogESCondition;
import com.star.tdpersonal.common.dal.elastic.blog.entity.BlogESDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tdpersonal
 * @Description: 博客Mapper
 * @author: xinsida
 * @create: 2021-06-15 18:12
 **/
@Mapper
public interface BlogMapper {

    /**
     * 搜索博客
     *
     * @param condition
     * @return
     */
    List<BlogESDO> queryBlogList(@Param("condition") BlogESCondition condition);

}
