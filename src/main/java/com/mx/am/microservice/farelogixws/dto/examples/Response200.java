package com.mx.am.microservice.farelogixws.dto.examples;

import com.mx.am.framework.model.enums.MessageTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@ApiModel
@Setter
@Getter
public class Response200 {
      @ApiModelProperty(example = "RESPONSE_MESSAGE", name = "messageType", dataType = "enum", position = 1)
      private MessageTypeEnum messageType;

      @ApiModelProperty(example = "fcd034bb-2e5c-4b59-908d-caf275fc10ac", name = "transactionID", dataType = "string", position = 2)
      private String transactionID;

      @ApiModelProperty(example = "OK", name = "httpStatus", dataType = "enum", position = 3)
      private HttpStatus httpStatus;

      @ApiModelProperty(example = "2021-04-07 16:21:36:03", name = "timestamp", dataType = "string", position = 4)
      private String timestamp;

      @ApiModelProperty(example = "Microservice working fine", name = "message", dataType = "string", position = 5)
      private String message;

      @ApiModelProperty(example = "{\n" +
              "    \"Version\": \"0.0.4-SNAPSHOT\",\n" +
              "    \"Microservice\": \"am-microservice-farelogixws\"\n" +
              "  }",
              name = "data", dataType = "Object", position = 6)
      private Object data;

}
