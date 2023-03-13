package com.seata.storage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2023/3/13 14:27
 * @Description MyBatis配置
 * @since version-1.0
 */
@Configuration
@MapperScan({"com.seata.storage.mapper"})
public class MyBatisConfig {
}