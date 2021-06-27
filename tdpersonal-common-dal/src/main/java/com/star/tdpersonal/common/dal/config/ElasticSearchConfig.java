package com.star.tdpersonal.common.dal.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.elasticsearch.xpack.sql.jdbc.EsDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @program: tdpersonal
 * @description: es配置项
 * @author: xinsida
 * @create: 2021-06-26 08:28
 **/
@Configuration
@MapperScan(basePackages={"com.star.tdpersonal.common.dal.elastic.*.mapper.single"}, sqlSessionFactoryRef="esSqlSessionFactory")
public class ElasticSearchConfig {

    @Bean(name = "elasticSearchDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.es")
    public DataSource elasticSearchDataSource() {
        return new EsDataSource();
    }

    @Bean(name = "esSqlSessionFactory")
    public SqlSessionFactory esSqlSessionFactory(@Qualifier("elasticSearchDataSource") DataSource esDateSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(esDateSource);
        sessionFactory.setConfigLocation(new ClassPathResource("/mybatis/mybatis-config-es-single.xml"));
        return sessionFactory.getObject();
    }

}
