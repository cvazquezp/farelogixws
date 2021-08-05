package com.mx.am.microservice.farelogixws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.mx.am"})
@EnableMongoRepositories(basePackages = "com.mx.am.microservice.farelogixws.repository")
@EnableJpaRepositories({"com.mx.am.microservice.farelogixws.repository", "com.mx.am.framework"})
@EntityScan({"com.mx.am.microservice.farelogixws.entity","com.mx.am.framework.entity","com.mx.am.framework.commons.entities"})
public class FarelogixApplication {
      public static void main(String[] args) {
            SpringApplication.run(FarelogixApplication.class, args);
      }
}
