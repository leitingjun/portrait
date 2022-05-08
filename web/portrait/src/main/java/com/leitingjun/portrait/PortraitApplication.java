package com.leitingjun.portrait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
@MapperScan(basePackages = "com.leitingjun.portrait.mapper")
@SpringBootApplication()
public class PortraitApplication {

	public static void main(String[] args) {
//		Object randomKey = redisTemplate.randomKey();

		SpringApplication.run(PortraitApplication.class, args);
		SpringApplication.getShutdownHandlers().add(new Runnable() {
			@Override
			public void run() {
				System.out.println("关闭钩子");
			}
		});
	}

}
