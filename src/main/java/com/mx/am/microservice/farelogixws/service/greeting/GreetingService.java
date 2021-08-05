package com.mx.am.microservice.farelogixws.service.greeting;


import com.mx.am.framework.dto.ValidCustomerDTO;
import com.mx.am.framework.exceptionhandler.exception.BusinessException;
import com.mx.am.framework.exceptionhandler.exception.ComponentException;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.exceptionhandler.exception.ProviderException;
import com.mx.am.framework.model.RequestServiceMessage;
import com.mx.am.framework.model.ResponseServiceMessage;

public interface GreetingService {
      ResponseServiceMessage getGreetingWithName(RequestServiceMessage request, ValidCustomerDTO customerDTO) throws ComponentException, InfraestructureException, ProviderException, BusinessException;
}
