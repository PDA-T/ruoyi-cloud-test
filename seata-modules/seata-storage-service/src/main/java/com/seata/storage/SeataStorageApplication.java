package com.seata.storage;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2023/3/13 15:55
 * @Description 库存服务
 * @since version-1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)// 取消数据源自动代理
@MapperScan("com.seata.storage.mapper")// 扫描mapper
@EnableFeignClients(basePackages = {"com.seata.storage.service","com.ruoyi.system.api"})// Feign客户端
@EnableCustomSwagger2// 文档
@EnableCustomConfig// 配置
@EnableDiscoveryClient// 服务注册
public class SeataStorageApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeataStorageApplication.class,args);
	}
}
