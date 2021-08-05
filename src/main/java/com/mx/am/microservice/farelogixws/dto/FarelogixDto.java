package com.mx.am.microservice.farelogixws.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FarelogixDto implements Serializable {
      private static final long serialVersionUID = 3269292864425098014L;
      private String name;
      private String description;
}
