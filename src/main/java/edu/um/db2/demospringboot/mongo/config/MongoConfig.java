package edu.um.db2.demospringboot.mongo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${mongo.uri:mongodb://localhost:27017,localhost:27018}")
    String uri;
    @Value("${mongo.database:prueba}")
    String databaseName;

    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient(
                new MongoClientURI(uri));
    }

    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    MongoDatabase createMongoDatabase(@Autowired MongoClient client) {
        return client.getDatabase(getDatabaseName());
    }


}
