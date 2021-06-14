package com.star;

import org.apache.dubbo.config.annotation.Service;

/**
 * @program: tdpersonal
 * @description
 * @author: xinsida
 * @create: 2021-06-14 23:41
 **/
@Service(timeout = 5000, version = "1.0.0.daily", group = "dubbo")
public class HelloWorldServiceImpl implements IHelloWorldService{
    @Override
    public String helloWorld() {
        return null;
    }
}
