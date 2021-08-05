package com.mx.am.microservice.farelogixws.controller.management;


import com.mx.am.microservice.farelogixws.dto.examples.*;
import com.mx.am.framework.model.ResponseServiceMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@RestController
@RequestMapping("/management/")
@Api(value = "Management", tags = "Management")
public class ManagementController {

      @Value("${info.microservice.version}")
      private String version;

      @Value("${info.microservice.name}")
      private String name;

      @ApiOperation(
              nickname = "Microservice Info (healtcheck)",
              value = "healthcheck",
              notes = "Displays microservice info.",
              response = Response200.class
      )
      @ApiResponses(value = {
              @ApiResponse(code = 401, message = "Unauthorized.", response = Response401.class),
              @ApiResponse(code = 400, message = "Bad request.", response = Response400.class),
              @ApiResponse(code = 403, message = "Forbidden.", response = Response403.class),
              @ApiResponse(code = 404, message = "Resource not found.", response = Response404.class),
              @ApiResponse(code = 500, message = "Internal Server Error.", response = Response500.class),
              @ApiResponse(code = 503, message = "Service Unavailable.", response = Response503.class)})
      @GetMapping("/info")
      public ResponseEntity<Object> getMicroserviceInfo(HttpServletRequest requestHttp) {
            var info = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withTransactionID(UUID.randomUUID().toString())
                    .withMessage("Microservice working fine")
                    .withData(new TreeMap<>(
                            Map.of(
                                    "Version", version,
                                    "Microservice", name
                            )
                    ))
                    .withHttpStatus(HttpStatus.OK)
                    .build();
            return new ResponseEntity<>(info, info.getHttpStatus());
      }
}
