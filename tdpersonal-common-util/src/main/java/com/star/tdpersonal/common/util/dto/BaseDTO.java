package com.star.tdpersonal.common.util.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tdpersonal
 * @description: 传输基类
 * @author: xinsida
 * @create: 2021-06-15 21:16
 **/
@Data
public class BaseDTO implements Serializable {

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
     * 操作人
     */
    private String operatorName;

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 参数校验
     *
     * @return
     */
    public boolean validate() {
        return true;
    }

}
