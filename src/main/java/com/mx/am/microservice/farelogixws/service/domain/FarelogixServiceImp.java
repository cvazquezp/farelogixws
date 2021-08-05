package com.mx.am.microservice.farelogixws.service.domain;


import com.mx.am.microservice.farelogixws.entity.Farelogix;
import com.mx.am.framework.model.ResponseServiceMessage;
import com.mx.am.microservice.farelogixws.repository.FarelogixRepository;
import org.springframework.stereotype.Service;


@Service("serviceImpl")
public class FarelogixServiceImp implements FarelogixService {
      private final FarelogixRepository domainNameRepository;

      public FarelogixServiceImp(FarelogixRepository domainNameRepository) {
            this.domainNameRepository = domainNameRepository;
      }

      public ResponseServiceMessage<Farelogix> getAllFarelogix() {
            ResponseServiceMessage<Farelogix> responseServiceMessage = new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withTransactionID("38301c64-16b6-406f-baa3-21668b18aa6d")
                    .withData(domainNameRepository.findAll())
                    .withMessage("Domain list")
                    .build();
            return responseServiceMessage;
      }
}
