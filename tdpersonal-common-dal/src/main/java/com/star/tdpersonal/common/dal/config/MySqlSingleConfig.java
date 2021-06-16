package com.star.tdpersonal.common.dal.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @program: tdpersonal
 * @Description: mysql单库配置项
 * @author: xinsida
 * @create: 2021-06-15 15:26
 **/
@Configuration
public class MySqlSingleConfig {

    @Bean(name = "mysqlSingleDataSource")
    @ConfigurationProperties(prefix = "mysql")
    public DataSource mysqlSingleDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 默认sqlSessionFactory为mysql
     *
     * @param mySqlSingleDataSource
     * @param configLocation
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = "mysqlSingleSqlSessionFactory")
    public SqlSessionFactory mysqlSingleSqlSessionFactory(@Qualifier("mysqlSingleDataSource") DataSource mySqlSingleDataSource,
                                                          @Value("classpath:mybatis/mybatis-config-mysql-single.xml") Resource configLocation) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mySqlSingleDataSource);
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.star.tdpersonal.common.dal.*.entity");
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 默认sqlSessionTemplate为mysql
     *
     * @param mysqlSingleSqlSessionFactory
     * @return
     */
    @Primary
    @Bean(name = "mysqlSingleSqlSessionTemplate")
    public SqlSessionTemplate mysqlSingleSqlSessionTemplate(@Qualifier("mysqlSingleSqlSessionFactory") SqlSessionFactory mysqlSingleSqlSessionFactory) {
        return new SqlSessionTemplate(mysqlSingleSqlSessionFactory);
    }

    /**
     * 开启事务
     *
     * @param mySqlSingleDataSource
     * @return
     */
    @Bean(name = "mysqlSingleTransactionManager")
    public PlatformTransactionManager mysqlSingleTransactionManager(@Qualifier("mysqlSingleDataSource") DataSource mySqlSingleDataSource) {
        return new DataSourceTransactionManager(mySqlSingleDataSource);
    }

    /**
     * 事务模板
     *
     * @param mysqlSingleTransactionManager
     * @return
     */
    @Bean(name = "mysqlSingleTansactionTemplate")
    public TransactionTemplate mysqlSingleTansactionTemplate(@Qualifier("mysqlSingleTransactionManager") PlatformTransactionManager mysqlSingleTransactionManager) {
        return new TransactionTemplate(mysqlSingleTransactionManager);
    }

    /**
     * Mapper扫描路径
     *
     * @return
     */
    @Bean(name = "mysqlSingleMapperScannerConfigurer")
    public MapperScannerConfigurer mysqlSingleMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mysqlSingleSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.star.tdpersonal.common.dal.*.mapper.single.mysql");
        return mapperScannerConfigurer;
    }

}
