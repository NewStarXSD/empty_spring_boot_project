package com.star.tdpersonal.biz.manager.blog.dto;

import com.star.tdpersonal.common.util.dto.BaseDTO;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: tdpersonal
 * @description: 博客传输类
 * @author: xinsida
 * @create: 2021-06-15 21:13
 **/
@Data
public class BlogDTO extends BaseDTO {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    @Override
    public boolean validate() {
        return super.validate()
                && StringUtils.isNotEmpty(title)
                && null != getOperatorId()
                && StringUtils.isNotEmpty(getOperatorName());
    }

}
