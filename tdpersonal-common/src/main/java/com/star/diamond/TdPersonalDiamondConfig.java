package com.star.diamond;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @program: tdpersonal
 * @description
 * @author: xinsida
 * @create: 2021-06-14 21:20
 **/
@Component
public class TdPersonalDiamondConfig implements InitializingBean {

    @Value("${nacos.config.server-addr}")
    private String serverAddr;

    private String testValue;

    @Override
    public void afterPropertiesSet() throws Exception {
        String dataId = DiamondConfigConstants.DATA_ID;
        String group = DiamondConfigConstants.GROUP;
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        getValueFromConfig(content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                getValueFromConfig(configInfo);
            }
            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }

    private void getValueFromConfig(String configInfo){
        Map map = JSONObject.parseObject(configInfo, Map.class);
        testValue = MapUtils.getString(map,"test");
    }

    public String getTestValue(){
        return testValue;
    }

}
