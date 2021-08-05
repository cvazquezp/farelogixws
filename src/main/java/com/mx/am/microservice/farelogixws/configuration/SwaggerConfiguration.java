package com.mx.am.microservice.farelogixws.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

      @Bean
      public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.mx.am.microservice.farelogixws.controller"))
                    .paths(PathSelectors.any())
                    .paths(Predicates.not(PathSelectors.regex("/error")))
                    .build();
      }

      @Bean
      public ApiInfo apiInfo() {
            Contact contact = new Contact(
                    "Phoenix Team",
                    "dev-portal",
                    "phoenix-team@aeromexico.com");

            return new ApiInfo(
                    "AM Microservice API",
                    "REST API",
                    "0.0.1",
                    "am/terms-of-service.com",
                    contact, "", "", new ArrayList<>());
      }
}
