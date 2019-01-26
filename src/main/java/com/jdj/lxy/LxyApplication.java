package com.jdj.lxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@MapperScan("com.jdj.lxy.mapper")
@ServletComponentScan("com.jdj.lxy.filter")
@ComponentScan("com.jdj.lxy.util")
@ComponentScan("com.jdj.lxy.controller")*/
public class LxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LxyApplication.class, args);
	}

}

