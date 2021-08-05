package com.mx.am.microservice.farelogixws.dto.examples;

import com.mx.am.microservice.farelogixws.dto.FarelogixDto;
import com.mx.am.microservice.farelogixws.entity.Farelogix;
import com.mx.am.framework.model.enums.MessageTypeEnum;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
class DtoExamplesTest {

      @Test
      void response200Test() {
            Response200 response200 = new Response200();
            response200.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response200.setTransactionID(UUID.randomUUID().toString());
            response200.setHttpStatus(HttpStatus.OK);
            response200.setTimestamp("");
            response200.setMessage("");
            response200.setData("");

            Assertions.assertNotNull(response200.getMessageType());
            Assertions.assertNotNull(response200.getTransactionID());
            Assertions.assertNotNull(response200.getHttpStatus());
            Assertions.assertNotNull(response200.getTimestamp());
            Assertions.assertNotNull(response200.getMessage());
            Assertions.assertNotNull(response200.getData());
      }

      @Test
      void response403Test() {
            Response403 response403 = new Response403();
            response403.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response403.setTransactionID(UUID.randomUUID().toString());
            response403.setHttpStatus(HttpStatus.OK);
            response403.setTimestamp("");
            response403.setErrorCode("");
            response403.setMessage("");
            response403.setEvent("");
            response403.setDetails("");
            response403.setSubErrors(new ArrayList<>());

            Assertions.assertNotNull(response403.getMessageType());
            Assertions.assertNotNull(response403.getTransactionID());
            Assertions.assertNotNull(response403.getHttpStatus());
            Assertions.assertNotNull(response403.getTimestamp());
            Assertions.assertNotNull(response403.getErrorCode());
            Assertions.assertNotNull(response403.getMessage());
            Assertions.assertNotNull(response403.getEvent());
            Assertions.assertNotNull(response403.getDetails());
            Assertions.assertNotNull(response403.getSubErrors());

      }

      @Test
      void response404Test() {
            Response404 response404 = new Response404();
            response404.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response404.setTransactionID(UUID.randomUUID().toString());
            response404.setHttpStatus(HttpStatus.OK);
            response404.setTimestamp("");
            response404.setErrorCode("");
            response404.setMessage("");
            response404.setEvent("");
            response404.setDetails("");
            response404.setSubErrors(new ArrayList<>());

            Assertions.assertNotNull(response404.getMessageType());
            Assertions.assertNotNull(response404.getTransactionID());
            Assertions.assertNotNull(response404.getHttpStatus());
            Assertions.assertNotNull(response404.getTimestamp());
            Assertions.assertNotNull(response404.getErrorCode());
            Assertions.assertNotNull(response404.getMessage());
            Assertions.assertNotNull(response404.getEvent());
            Assertions.assertNotNull(response404.getDetails());
            Assertions.assertNotNull(response404.getSubErrors());

      }

      @Test
      void response401Test() {
            Response401 response401 = new Response401();
            response401.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response401.setTransactionID(UUID.randomUUID().toString());
            response401.setHttpStatus(HttpStatus.OK);
            response401.setTimestamp("");
            response401.setErrorCode("");
            response401.setMessage("");
            response401.setEvent("");
            response401.setDetails("");
            response401.setSubErrors(new ArrayList<>());

            Assertions.assertNotNull(response401.getMessageType());
            Assertions.assertNotNull(response401.getTransactionID());
            Assertions.assertNotNull(response401.getHttpStatus());
            Assertions.assertNotNull(response401.getTimestamp());
            Assertions.assertNotNull(response401.getErrorCode());
            Assertions.assertNotNull(response401.getMessage());
            Assertions.assertNotNull(response401.getEvent());
            Assertions.assertNotNull(response401.getDetails());
            Assertions.assertNotNull(response401.getSubErrors());
      }

      @Test
      void response400Test() {
            Response400 response400 = new Response400();
            response400.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response400.setTransactionID(UUID.randomUUID().toString());
            response400.setHttpStatus(HttpStatus.OK);
            response400.setTimestamp("");
            response400.setErrorCode("");
            response400.setMessage("");
            response400.setEvent("");
            response400.setDetails("");
            response400.setSubErrors(new ArrayList<>());

            Assertions.assertNotNull(response400.getMessageType());
            Assertions.assertNotNull(response400.getTransactionID());
            Assertions.assertNotNull(response400.getHttpStatus());
            Assertions.assertNotNull(response400.getTimestamp());
            Assertions.assertNotNull(response400.getErrorCode());
            Assertions.assertNotNull(response400.getMessage());
            Assertions.assertNotNull(response400.getEvent());
            Assertions.assertNotNull(response400.getDetails());
            Assertions.assertNotNull(response400.getSubErrors());
      }

      @Test
      void response503Test() {
            Response503 response503 = new Response503();
            response503.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response503.setTransactionID(UUID.randomUUID().toString());
            response503.setHttpStatus(HttpStatus.OK);
            response503.setTimestamp("");
            response503.setErrorCode("");
            response503.setMessage("");
            response503.setEvent("");
            response503.setDetails("");
            response503.setSubErrors(new ArrayList<>());

            Assertions.assertNotNull(response503.getMessageType());
            Assertions.assertNotNull(response503.getTransactionID());
            Assertions.assertNotNull(response503.getHttpStatus());
            Assertions.assertNotNull(response503.getTimestamp());
            Assertions.assertNotNull(response503.getErrorCode());
            Assertions.assertNotNull(response503.getMessage());
            Assertions.assertNotNull(response503.getEvent());
            Assertions.assertNotNull(response503.getDetails());
            Assertions.assertNotNull(response503.getSubErrors());
      }

      @Test
      void response500Test() {
            Response500 response500 = new Response500();
            response500.setMessageType(MessageTypeEnum.RESPONSE_MESSAGE);
            response500.setTransactionID(UUID.randomUUID().toString());
            response500.setHttpStatus(HttpStatus.OK);
            response500.setTimestamp("");
            response500.setErrorCode("");
            response500.setMessage("");
            response500.setEvent("");
            response500.setDetails("");
            response500.setSubErrors(new ArrayList<>());

            Assertions.assertNotNull(response500.getMessageType());
            Assertions.assertNotNull(response500.getTransactionID());
            Assertions.assertNotNull(response500.getHttpStatus());
            Assertions.assertNotNull(response500.getTimestamp());
            Assertions.assertNotNull(response500.getErrorCode());
            Assertions.assertNotNull(response500.getMessage());
            Assertions.assertNotNull(response500.getEvent());
            Assertions.assertNotNull(response500.getDetails());
            Assertions.assertNotNull(response500.getSubErrors());
      }

      @Test
      void domainEntityTest() {
            Farelogix domain = new Farelogix();
            domain.set_id(new ObjectId());
            domain.setDescription("");
            domain.setName("");

            FarelogixDto dto = new FarelogixDto();
            dto.setDescription("");
            dto.setName("");

            Assertions.assertNotNull(domain.get_id());
            Assertions.assertNotNull(domain.getDescription());
            Assertions.assertNotNull(domain.getName());

            Assertions.assertNotNull(dto.getDescription());
            Assertions.assertNotNull(dto.getName());
      }
}