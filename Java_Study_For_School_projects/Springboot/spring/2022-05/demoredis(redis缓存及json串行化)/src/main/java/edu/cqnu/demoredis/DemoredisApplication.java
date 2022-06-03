package edu.cqnu.demoredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("edu.cqnu.demoredis.mapper")
@EnableCaching
public class DemoredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoredisApplication.class, args);
	}

}
