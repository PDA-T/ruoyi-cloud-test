package com.streaming.media;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date 2022/11/30 20:05
 * @Description 车场管理
 * @since version-1.0
 */
@SpringBootApplication
@MapperScan("com.streaming.media.mapper")// 扫描mapper
@EnableRyFeignClients// Feign客户端
@EnableCustomSwagger2// 文档
@EnableCustomConfig// 配置
public class StreamingMediaApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamingMediaApplication.class,args);
	}
}
