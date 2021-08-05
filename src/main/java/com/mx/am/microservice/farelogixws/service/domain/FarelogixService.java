package com.mx.am.microservice.farelogixws.service.domain;

import com.mx.am.microservice.farelogixws.entity.Farelogix;
import com.mx.am.framework.exceptionhandler.exception.BusinessException;
import com.mx.am.framework.exceptionhandler.exception.ComponentException;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.exceptionhandler.exception.ProviderException;
import com.mx.am.framework.model.ResponseServiceMessage;

public interface FarelogixService {
      ResponseServiceMessage<Farelogix> getAllFarelogix() throws BusinessException, ComponentException, InfraestructureException, ProviderException;
}
