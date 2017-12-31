package com.adsanche.springwebflux.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

/**
 * Created by adsanche on 23/06/17.
 */
@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    private String DATABASE_NAME = "heroes";

    @Override
    public MongoClient mongoClient() {

        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {

        return DATABASE_NAME;
    }

    @Bean
    public ReactiveMongoDatabaseFactory reactiveMongoDbFactory(final MongoClient mongoClient) {

        return new SimpleReactiveMongoDatabaseFactory(mongoClient, DATABASE_NAME);
    }
}
