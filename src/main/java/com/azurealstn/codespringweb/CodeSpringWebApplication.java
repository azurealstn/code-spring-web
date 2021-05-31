package com.azurealstn.codespringweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = CodeSpringWebApplication.class)
@SpringBootApplication
public class CodeSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeSpringWebApplication.class, args);
	}

}
