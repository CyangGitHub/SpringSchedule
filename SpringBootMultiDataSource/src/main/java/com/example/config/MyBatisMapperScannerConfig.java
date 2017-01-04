package com.example.config;

/**
 * Created by mulder on 2016/11/3.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@MapperScan("com.example.*.mapper")
@AutoConfigureAfter(DataSource.class)
public class MyBatisMapperScannerConfig {
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.example.*.mapper");
        return mapperScannerConfigurer;
    }
}