package com.mx.am.microservice.farelogixws.dto.examples;

import com.mx.am.framework.model.ResponseErrorMessage;
import com.mx.am.framework.model.enums.MessageTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@ApiModel
@Setter
@Getter
public class Response500 {
      @ApiModelProperty(example = "ERROR_MESSAGE", name = "messageType", dataType = "enum", position = 1)
      private MessageTypeEnum messageType;

      @ApiModelProperty(example = "5826871a-3ae5-4755-b173-459fa28c58de", name = "transactionID", dataType = "string", position = 2)
      private String transactionID;

      @ApiModelProperty(example = "INTERNAL_SERVER_ERROR", name = "httpStatus", dataType = "enum", position = 3)
      private HttpStatus httpStatus;

      @ApiModelProperty(example = "2021-04-07 16:21:36:03", name = "timestamp", dataType = "string", position = 4)
      private String timestamp;

      @ApiModelProperty(example = "INTERNAL_SERVER_ERROR", name = "errorCode", dataType = "string", position = 5)
      private String errorCode;

      @ApiModelProperty(example = "Internal Server Error", name = "message", dataType = "string", position = 6)
      private String message;

      @ApiModelProperty(example = "ABORT", name = "event", dataType = "string", position = 7)
      private String event;

      @ApiModelProperty(example = "details", name = "details", dataType = "string", position = 8)
      private String details;

      @ApiModelProperty(example = "[]", name = "subErrors", dataType = "List", position = 9)
      private List<ResponseErrorMessage> subErrors;

}
