package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages="com")//@RestController,Service,Repo
@EntityScan(basePackages="com")
public class DemoTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SpringApplication.run(DemoTest.class, args);
		System.out.println("Spring Boot is ready");
	}
}
