package com.mx.am.microservice.farelogixws.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ComponentScan({"com.mx.am.microservice.farelogixws"})
public class MongoClientConfiguration {

      @Value("${spring.data.mongodb.host}")
      private String host;

      @Value("${spring.data.mongodb.database}")
      private String dataBase;

      @Value("${spring.data.mongodb.username}")
      private String username;

      @Value("${spring.data.mongodb.password}")
      private String password;

      @Value("${spring.data.mongodb.port}")
      private String port;

      @Value("${mongo.timeout}")
      private String timeout;

      @Bean
      protected String getDatabaseName() {
            return dataBase;
      }

      @Bean
      public MongoClient mongo() {
            ConnectionString connectionString = new ConnectionString(
                    "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + getDatabaseName() + "?serverSelectionTimeoutMS=" + timeout + "&connectTimeoutMS=" + timeout
            );
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            return MongoClients.create(mongoClientSettings);
      }

      @Bean
      public MongoTemplate mongoTemplate() {
            return new MongoTemplate(mongo(), dataBase);
      }

}
