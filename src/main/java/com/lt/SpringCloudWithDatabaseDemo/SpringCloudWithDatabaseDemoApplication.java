package com.lt.SpringCloudWithDatabaseDemo;

import com.lt.controller.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = DemoController.class)
public class SpringCloudWithDatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWithDatabaseDemoApplication.class, args);
	}

}
