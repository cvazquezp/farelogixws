package com.mx.am.microservice.farelogixws.service.domain;

import com.mx.am.microservice.farelogixws.dao.FarelogixDAO;
import com.mx.am.microservice.farelogixws.entity.Farelogix;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.model.ErrorMessage;
import com.mx.am.framework.model.RequestServiceMessage;
import com.mx.am.framework.model.ResponseServiceMessage;
import com.mx.am.framework.service.ErrorManagerService;
import com.mx.am.framework.util.Constants;
import org.springframework.stereotype.Service;

@Service("serviceDaoImpl")
public class FarelogixServiceDaoImp implements FarelogixService {
      private final FarelogixDAO domainNameDAO;

      private final ErrorManagerService errorManagerService;


      public FarelogixServiceDaoImp(FarelogixDAO domainNameDAO, ErrorManagerService errorManagerService) {
            this.domainNameDAO = domainNameDAO;
            this.errorManagerService = errorManagerService;
      }

      @Override
      public ResponseServiceMessage<Farelogix> getAllFarelogix() throws InfraestructureException {
            try {
                  var responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                          .withTransactionID("38301c64-16b6-406f-baa3-21668b18aa6d")
                          .withData(domainNameDAO.getAll())
                          .withMessage("Domain list")
                          .build();
                  return responseServiceMessage;
            } catch (Exception e) {
                  ErrorMessage errorMessage = errorManagerService.getErrorMessageByCustomerAndCode(
                          1, 1, 1, Constants.MODULE, Constants.DB_KEY, Constants.DB_DISCONNECTION_KEY
                  );

                  RequestServiceMessage requestServiceMessage = new RequestServiceMessage.RequestServiceMessageBuilder()
                          .withTransactionId("d71927d3-1a5a-459d-8ec6-61adbbab4c4c")
                          .build();

                  throw new InfraestructureException.InfraestructureExceptionBuilder().withErrorMessage(errorMessage)
                          .withRequestServiceMessage(requestServiceMessage).withMessage(e.getMessage())
                          .withDetails(e.getLocalizedMessage())
                          .withCause(e)
                          .build();
            }

      }
}
