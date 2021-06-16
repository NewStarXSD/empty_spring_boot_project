package com.star.tdpersonal.biz.service.blog.dubbo.service;

import com.google.common.base.Preconditions;
import com.star.tdpersonal.api.IBlogManageHsfService;
import com.star.tdpersonal.biz.manager.blog.BlogManager;
import com.star.tdpersonal.biz.manager.blog.dto.BlogDTO;
import com.star.tdpersonal.common.util.common.LoggerNames;
import com.star.tdpersonal.common.util.constants.ServiceMessageConstants;
import com.star.tdpersonal.common.util.dto.ResultDTO;
import com.star.tdpersonal.common.util.enums.ErrorMessageEnums;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @program: tdpersonal
 * @description: 博客dubbo接口服务实现
 * @author: xinsida
 * @create: 2021-06-16 11:23
 **/
@Service
@Slf4j(topic = LoggerNames.SERVICE)
public class BlogManageHsfServiceImpl implements IBlogManageHsfService {

    @Resource
    private BlogManager blogManager;

    @Override
    public ResultDTO<Boolean> createBlog(BlogDTO blogDTO) {
        log.info("in@BlogManageHsfServiceImpl createBlog blogDTO = {}", blogDTO);
        Preconditions.checkArgument(null != blogDTO, ServiceMessageConstants.PARAM_IS_NULL, "blogDTO");
        if (!blogDTO.validate()) {
            return ResultDTO.failed(ErrorMessageEnums.PARAM_INVALID);
        }
        return ResultDTO.succeed(blogManager.createBlog(blogDTO));
    }
}
