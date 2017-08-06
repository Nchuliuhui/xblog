package com.xp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xp.dao")
public class XblogApplication {
	public static void main(String[] args) {
		SpringApplication.run(XblogApplication.class, args);
	}
}
