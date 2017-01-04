package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by admin on 2016/11/25.
 */
@Configuration
public class DataSourceConfig {

    @Bean(name="mysqlDataSource")
    @Qualifier("mysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix ="spring.datasource.mysql" )
    public DataSource mysqlDataSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean(name="oracleDataSource")
    @Qualifier("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracleDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Qualifier("mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "oracleSqlSessionFactory")
    @Qualifier("oracleSqlSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

}
