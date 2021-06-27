package com.star.tdpersonal.common.dal.elastic.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: tdpersonal
 * @description: 博客es数据模型
 * @author: xinsida
 * @create: 2021-06-26 19:13
 **/
@Data
public class BlogESDO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 作者信息
     */
    private String author;

    /**
     * 类型
     */
    private String type;

}
