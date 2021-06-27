package com.star.tdpersonal.api;

import com.star.tdpersonal.biz.manager.blog.dto.TestDTO;
import com.star.tdpersonal.common.util.dto.ResultDTO;

/**
 * @program: tdpersonal
 * @description: 博客dubbo接口
 * @author: xinsida
 * @create: 2021-06-16 10:58
 **/
public interface ITestManageHsfService {

    /**
     * 创建博客
     * @param testDTO
     * @return
     */
    ResultDTO<Boolean> createTest(TestDTO testDTO);

}
