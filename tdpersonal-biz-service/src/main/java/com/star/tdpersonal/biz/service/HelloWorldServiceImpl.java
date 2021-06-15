package com.star.tdpersonal.biz.service;

import com.star.tdpersonal.api.IHelloWorldService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @program: tdpersonal
 * @description: helloWorld dubbo服务实现
 * @author: xinsida
 * @create: 2021-06-14 23:41
 **/
@Service(timeout = 5000, version = "1.0.0.daily", group = "dubbo")
public class HelloWorldServiceImpl implements IHelloWorldService {
    @Override
    public String helloWorld() {
        return null;
    }
}
