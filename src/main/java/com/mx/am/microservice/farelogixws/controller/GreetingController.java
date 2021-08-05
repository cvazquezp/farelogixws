package com.mx.am.microservice.farelogixws.controller;


import com.mx.am.framework.dto.ValidCustomerDTO;
import com.mx.am.framework.exceptionhandler.exception.BusinessException;
import com.mx.am.framework.exceptionhandler.exception.ComponentException;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.exceptionhandler.exception.ProviderException;
import com.mx.am.framework.logmanager.service.LogManagerService;
import com.mx.am.framework.model.LogEventMessage;
import com.mx.am.framework.model.RequestServiceMessage;
import com.mx.am.framework.model.enums.LogLevelEnum;
import com.mx.am.framework.requestvalidator.ValidatorHeader;
import com.mx.am.microservice.farelogixws.service.greeting.GreetingService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/v1/greetings")
@Api(value = "Greeting", tags = "Example controller")
public class GreetingController {

      private final GreetingService greetingService;
      private final LogManagerService logManagerService;
      private final ValidatorHeader validatorHeader;


      public GreetingController(GreetingService greetingService, LogManagerService logManagerService, ValidatorHeader validatorHeader) {
            this.greetingService = greetingService;
            this.logManagerService = logManagerService;
            this.validatorHeader = validatorHeader;
            logManagerService.initializeLogger(this.getClass());
      }

      @GetMapping("/greeting/{name}")
      public ResponseEntity<Object> getGreetingWithName(HttpServletRequest httpServletRequest, @PathVariable String name) throws BusinessException, ProviderException, ComponentException, InfraestructureException {
            RequestServiceMessage requestServiceMessage = buildRequestServiceMessageWithHeadersFromServletRequest(httpServletRequest);
            ValidCustomerDTO validCustomerDTO = validateHeaders(requestServiceMessage);

            requestServiceMessage.setTransactionID(UUID.randomUUID().toString());
            requestServiceMessage.setData(name);

            LogEventMessage<RequestServiceMessage> eventMessage = new LogEventMessage<>(requestServiceMessage, LogLevelEnum.DEBUG);
            eventMessage.setRequestServiceMessage(requestServiceMessage);
            logManagerService.logEventWithClass(eventMessage, this.getClass());

            var greetingWithName = greetingService.getGreetingWithName(requestServiceMessage, validCustomerDTO);
            return new ResponseEntity<>(greetingWithName, greetingWithName.getHttpStatus());
      }

      private ValidCustomerDTO validateHeaders(RequestServiceMessage requestServiceMessage) throws BusinessException {
            return validatorHeader.validate(requestServiceMessage);
      }

      private RequestServiceMessage buildRequestServiceMessageWithHeadersFromServletRequest(HttpServletRequest requestHttp) {
            HttpHeaders httpHeaders = new HttpHeaders();

            for (String h : Collections.list(requestHttp.getHeaderNames())) {
                  httpHeaders.put(h, Collections.list(requestHttp.getHeaders(h)));
            }

            RequestServiceMessage requestService = new RequestServiceMessage.RequestServiceMessageBuilder()
                    .withHttpHeaders(httpHeaders)
                    .build();
            return requestService;
      }
}
