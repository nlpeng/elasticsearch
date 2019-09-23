package com.nlpeng.es.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.nlpeng.es.mapper","com.nlpeng.es.dao"})
public class MyBatisConfig {
}
