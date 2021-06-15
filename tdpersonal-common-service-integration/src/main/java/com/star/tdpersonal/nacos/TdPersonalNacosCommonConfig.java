package com.star.tdpersonal.nacos;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.star.tdpersonal.nacos.model.TdPersonalNacosCommonConfigModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @program: tdpersonal
 * @description: 公共配置管理
 * @author: xinsida
 * @create: 2021-06-14 21:20
 **/
@Component
public class TdPersonalNacosCommonConfig implements InitializingBean, Listener {

    @Value("${nacos.config.server-addr}")
    private String serverAddr;

    private TdPersonalNacosCommonConfigModel tdPersonalNacosCommonConfigModel;

    private ConfigService configService;

    @Override
    public Executor getExecutor() {
        return null;
    }

    @Override
    public void receiveConfigInfo(String configInfo) {
        if (configInfo == null || StringUtils.length(configInfo.trim()) == 0) {
            return;
        }
        tdPersonalNacosCommonConfigModel = JSONObject.parseObject(configInfo, TdPersonalNacosCommonConfigModel.class);
    }

    /**
     * 初始化数据
     *
     * @param dataId
     * @param group
     */
    private void initData(String dataId, String group) {
        try {
            String configInfo = configService.getConfig(dataId, group, 60 * 1000);
            if (configInfo == null || StringUtils.length(configInfo.trim()) == 0) {
                return;
            }
            tdPersonalNacosCommonConfigModel = JSONObject.parseObject(configInfo, TdPersonalNacosCommonConfigModel.class);
        } catch (NacosException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void afterPropertiesSet() {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            configService = NacosFactory.createConfigService(properties);
            initData(NacosConfigConstants.DATA_ID, NacosConfigConstants.GROUP);
            configService.addListener(NacosConfigConstants.DATA_ID, NacosConfigConstants.GROUP, this);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前环境
     *
     * @return daily pre online
     */
    public String getEnv() {
        return tdPersonalNacosCommonConfigModel.getEnv();
    }

}
