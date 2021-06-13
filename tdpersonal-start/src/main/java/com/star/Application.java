package com.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: tdpersonal
 * @description
 * @author: xinsida
 * @create: 2021-06-13 18:04
 **/
@SpringBootApplication(scanBasePackages = "com.star")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
