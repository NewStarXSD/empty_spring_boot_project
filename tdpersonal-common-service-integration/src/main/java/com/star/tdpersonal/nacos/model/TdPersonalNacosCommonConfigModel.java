package com.star.tdpersonal.nacos.model;


/**
 * @program: tdpersonal
 * @Description: tdpersonal公共配置模型
 * @author: xinsida
 * @Date: 2021-06-15 15:45
 **/
public class TdPersonalNacosCommonConfigModel {

    private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "TdPersonalNacosCommonConfigModel{" +
                "env='" + env + '\'' +
                '}';
    }

}
