package com.lt.SpringCloudWithDatabaseDemo;

import com.lt.controller.DemoController;
import com.lt.repository.BookRepository;
import com.lt.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lt"})
@EnableJpaRepositories("com.lt.repository")
@EntityScan("com.lt.model")
public class SpringCloudWithDatabaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudWithDatabaseDemoApplication.class, args);
    }

}
