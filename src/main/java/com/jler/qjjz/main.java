package com.jler.qjjz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jler.qjjz.repository")
@EntityScan(basePackages = "com.jler.qjjz")
@EnableScheduling
public class main {

    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }

}