package com.star.tdpersonal.biz.manager.blog.dto;

import com.star.tdpersonal.common.util.dto.BaseDTO;

/**
 * @program: tdpersonal
 * @description: 博客传输类
 * @author: xinsida
 * @create: 2021-06-15 21:13
 **/
public class BlogDTO extends BaseDTO {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                "} " + super.toString();
    }
}
