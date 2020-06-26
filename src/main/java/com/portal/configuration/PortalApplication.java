package com.portal.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.portal.controller","com.portal.service"})
@EnableMongoRepositories(basePackages = {"com.portal.mongo.repo"})
@EntityScan(basePackages = "com.portal.mongo.domain")
public class PortalApplication {

    public static void main(String[] args) {

        SpringApplication.run(PortalApplication.class, args);
    }

}
