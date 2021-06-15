package com.star.tdpersonal.common.dal.blog.entity;


import lombok.Data;

import java.util.Date;

/**
 * @program: tdpersonal
 * @Description:博客数据库存储实体类
 * @author: xinsida
 * @Date: 2021-06-15 18:13
 **/
@Data
public class BlogDO {

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

}
