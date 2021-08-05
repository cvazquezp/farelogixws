package com.mx.am.microservice.farelogixws.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

      @Autowired
      private MockMvc mockMvc;

      @Value("${info.microservice.version}")
      private String version;

      @Value("${info.microservice.name}")
      private String name;


      @Test
      void domainRepositoryImplTest() throws Exception {
            mockMvc.perform(get("/api/v1/domain"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.transactionID").value("38301c64-16b6-406f-baa3-21668b18aa6d"))
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void domainDaoImplTest() throws Exception {
            mockMvc.perform(get("/api/v2/domain"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("Domain list"))
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void managementTest() throws Exception {
            mockMvc.perform(get("/management/info"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.data.Version").value(version))
                    .andExpect(jsonPath("$.data.Microservice").value(name))
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void greetingSuccess200Test() throws Exception {
            mockMvc.perform(
                    get("/v1/greetings/greeting/{name}", "Antonio")
                            .header("flow", "Booking")
                            .header("pos", "Web")
                            .header("client", "Ecommerce"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value("Hello Antonio"))
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void greetingInvalidHeaders400Test() throws Exception {
            mockMvc.perform(get("/v1/greetings/greeting/{name}", "Antonio"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errorCode").value("INVALID_HEADERS"))
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void greetingMongo503Test() throws Exception {
            mockMvc.perform(
                    get("/v1/greetings/greeting/{name}", "mongo")
                            .header("flow", "Booking")
                            .header("pos", "Web")
                            .header("client", "Ecommerce"))
                    .andExpect(status().isServiceUnavailable())
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void greetingComponent500Test() throws Exception {
            mockMvc.perform(
                    get("/v1/greetings/greeting/{name}", "component")
                            .header("flow", "Booking")
                            .header("pos", "Web")
                            .header("client", "Ecommerce"))
                    .andExpect(status().isInternalServerError())
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void greetingBusiness500Test() throws Exception {
            mockMvc.perform(
                    get("/v1/greetings/greeting/{name}", "$")
                            .header("flow", "Booking")
                            .header("pos", "Web")
                            .header("client", "Ecommerce"))
                    .andExpect(status().isInternalServerError())
                    .andDo(print())
                    .andReturn();
      }

      @Test
      void greetingProvider500Test() throws Exception {
            mockMvc.perform(
                    get("/v1/greetings/greeting/{name}", "sabre")
                            .header("flow", "Booking")
                            .header("pos", "Web")
                            .header("client", "Ecommerce"))
                    .andExpect(status().isInternalServerError())
                    .andDo(print())
                    .andReturn();
      }

}
