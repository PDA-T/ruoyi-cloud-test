package com.xxl.job;

import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2023/4/3 14:46
 * @Description 分布式任务
 * @since version-1.0
 */
@SpringBootApplication
@EnableFeignClients// Feign客户端
@EnableCustomSwagger2// 文档
public class XxlJobApplication {
	public static void main(String[] args) {
		SpringApplication.run(XxlJobApplication.class,args);
	}
}
