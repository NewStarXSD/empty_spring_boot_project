package com.star.tdpersonal.common.dal.elastic.blog.condition;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: tdpersonal
 * @description: 博客es查询条件类
 * @author: xinsida
 * @create: 2021-06-27 16:10
 **/
@Data
public class BlogESCondition implements Serializable {

    /**
     * 关键字
     */
    private String keyWord;

    /**
     * 类型
     */
    private String type;

    /**
     * 作者
     */
    private String author;

}
