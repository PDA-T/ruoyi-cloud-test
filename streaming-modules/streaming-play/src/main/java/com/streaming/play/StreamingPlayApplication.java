package com.streaming.play;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date 2023/3/20 17:26
 * @Description 流播放服务
 * @since version-1.0
 */
@SpringBootApplication
@MapperScan("com.streaming.play.mapper")// 扫描mapper
@EnableRyFeignClients// Feign客户端
@EnableCustomSwagger2// 文档
@EnableCustomConfig// 配置
public class StreamingPlayApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamingPlayApplication.class,args);
	}
}
