package com.portal.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoConnection;

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    public MongoClient mongoClient(){
        return MongoClients.create(new ConnectionString(mongoConnection));
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(),mongoDatabase);
    }

    @Bean
    public MongoAdminOperations mongoAdminOperations(){
       return new MongoAdmin(mongoClient());
    }
}
