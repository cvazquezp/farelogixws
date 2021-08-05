package com.mx.am.microservice.farelogixws.service.greeting;


import com.mx.am.framework.dto.ValidCustomerDTO;
import com.mx.am.framework.exceptionhandler.exception.BusinessException;
import com.mx.am.framework.exceptionhandler.exception.ComponentException;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.exceptionhandler.exception.ProviderException;
import com.mx.am.framework.model.ErrorMessage;
import com.mx.am.framework.model.RequestServiceMessage;
import com.mx.am.framework.model.ResponseServiceMessage;
import com.mx.am.framework.service.ErrorManagerService;
import com.mx.am.framework.util.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;


@Service
public class GreetingServiceImp implements GreetingService {
      private final ErrorManagerService errorManagerService;

      public GreetingServiceImp(ErrorManagerService errorManagerService) {
            this.errorManagerService = errorManagerService;
      }

      @Override
      public ResponseServiceMessage getGreetingWithName(RequestServiceMessage request, ValidCustomerDTO customerDTO) throws BusinessException, ComponentException, InfraestructureException, ProviderException {
            String name = (String) request.getData();
            validateName(name, customerDTO);
            String greeting = "Hello " + name;
            return new ResponseServiceMessage.ResponseServiceMessageBuilder()
                    .withData(greeting)
                    .withTransactionID("2b2b7ae7-f052-4964-a630-48640fca9326")
                    .withMessage("greeting")
                    .build();
      }

      private void validateName(String name, ValidCustomerDTO customerDTO) throws BusinessException, ComponentException, InfraestructureException, ProviderException {
            RequestServiceMessage requestServiceMessage = new RequestServiceMessage.RequestServiceMessageBuilder()
                    .withTransactionId("5244d4cc-3251-4d80-a55d-3a3de521018d")
                    .withComponentId("")
                    .withHttpHeaders(new HttpHeaders())
                    .withData(name)
                    .build();

            ErrorMessage errorMessage = new ErrorMessage.ErrorMessageBuilder()
                    .withCode("ERROR_MESSAGE_CODE")
                    .withMessage("MESSAGE")
                    .withLevel("FATAL")
                    .withEvent("ABORT")
                    .withHttpStatus(500)
                    .build();

            //Esto puede ser un try de conexion a mongo
            if (name.equals("mongo")) {
                  //Ejemplo para invocar al error message manager
                  ErrorMessage mongoErrorMessage = errorManagerService.getErrorMessageByCustomerAndCode(
                          customerDTO.getClient_id(), customerDTO.getFlow_id(), customerDTO.getFlow_id(),
                          Constants.MODULE, Constants.DB_KEY, Constants.DB_DISCONNECTION_KEY
                  );

                  throw new InfraestructureException.InfraestructureExceptionBuilder()
                          .withErrorMessage(mongoErrorMessage)
                          .withRequestServiceMessage(requestServiceMessage)
                          .withDetails("Infrastructure Details")
                          .build();
            }

            //Esta excepcion no la tengo clara
            if (name.equals("component")) {
                  throw new ComponentException.ComponentExceptionBuilder()
                          .withMessage("Component Exception")
                          .withDetails("Component Details")
                          .withRequestServiceMessage(requestServiceMessage)
                          .withErrorMessage(errorMessage)
                          .build();
            }

            //Esta puede ser una validacion de negocio
            if (name.contains("$")) {
                  throw new BusinessException.BusinessExceptionBuilder()
                          .withMessage("Invalid Name")
                          .withDetails("Business Details")
                          .withRequestServiceMessage(requestServiceMessage)
                          .withErrorMessage(errorMessage)
                          .build();
            }

            //Esta puede ser una excepcion de SABRE
            if (name.equals("sabre")) {
                  throw new ProviderException.ProviderExceptionBuilder()
                          .withMessage("Sabre Disconnection")
                          .withDetails("Disconnection Details")
                          .withRequestServiceMessage(requestServiceMessage)
                          .withErrorMessage(errorMessage)
                          .build();
            }
      }
}
