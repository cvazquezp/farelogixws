package com.mx.am.microservice.farelogixws.controller;


import com.mx.am.microservice.farelogixws.entity.Farelogix;
import com.mx.am.framework.exceptionhandler.exception.BusinessException;
import com.mx.am.framework.exceptionhandler.exception.ComponentException;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.exceptionhandler.exception.ProviderException;
import com.mx.am.framework.model.ResponseServiceMessage;
import com.mx.am.microservice.farelogixws.service.domain.FarelogixService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Api(value = "Domain", tags = "Domain example controller")
public class FarelogixControllerV1 {

      private final FarelogixService domainNameService;

      public FarelogixControllerV1(@Qualifier("serviceImpl") FarelogixService domainNameService) {
            this.domainNameService = domainNameService;
      }

      @GetMapping("/v1/domain")
      public ResponseEntity<Object> getAll() throws InfraestructureException, ProviderException, ComponentException, BusinessException {
            ResponseServiceMessage<Farelogix> all = domainNameService.getAllFarelogix();
            return new ResponseEntity<>(all, all.getHttpStatus());
      }

}
