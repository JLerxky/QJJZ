package com.jler.qjjz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jler.qjjz.repository")
@EntityScan(basePackages = "com.jler.qjjz")
public class main {

    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }

}