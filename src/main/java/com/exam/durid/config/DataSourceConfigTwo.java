package com.exam.durid.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 我是第二个数据源的配置
 */
@Configuration
@MapperScan(basePackages = "com.exam.durid.dao.cluster", sqlSessionTemplateRef  = "sqlSessionTemplateTwo")
public class DataSourceConfigTwo {


    @Bean(name = "dataSourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSourceTwo") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/cluster/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManagerTwo")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSourceTwo") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplateTwo")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
