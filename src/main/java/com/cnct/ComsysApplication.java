package com.cnct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.cnct.mapper")
@EnableCaching
@EnableScheduling
@EnableEurekaClient
//springboot提供的一个支持其他服务发现的注册器 注解
//@EnableDiscoveryClient
public class ComsysApplication{

	public static void main(String[] args) {
		SpringApplication.run(ComsysApplication.class, args);
	}

}
