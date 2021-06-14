package com.star;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: tdpersonal
 * @description
 * @author: xinsida
 * @create: 2021-06-13 18:04
 **/
@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.star")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
