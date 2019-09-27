package edu.um.db2.demospringboot.mongo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${mongo.host:localhost}")
    String host;
    @Value("${mongo.port:27017}")
    int port;
    @Value("${mongo.database:test}")
    String databaseName;

    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient(new ServerAddress(host, port),
                MongoClientOptions.builder()
                        .maxConnectionIdleTime(60*1000)
                        .maxConnectionLifeTime(60*1000)
                        .build());
    }

    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    MongoDatabase createMongoDatabase(@Autowired MongoClient client) {
        return client.getDatabase(getDatabaseName());
    }


}
