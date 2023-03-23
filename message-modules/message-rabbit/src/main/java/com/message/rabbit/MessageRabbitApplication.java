package com.message.rabbit;

import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Date 2023/3/23 9:55
 * @Description 消息服务
 * @since version-1.0
 */
@SpringBootApplication
@EnableFeignClients// Feign客户端
@EnableCustomSwagger2// 文档
public class MessageRabbitApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessageRabbitApplication.class,args);
	}
}
