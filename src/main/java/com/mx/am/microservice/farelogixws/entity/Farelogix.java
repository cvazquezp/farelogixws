package com.mx.am.microservice.farelogixws.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "__domain__")
public class Farelogix implements Serializable {
      private static final long serialVersionUID = -1051484621912964604L;
      @Id
      private ObjectId _id;
      private String name;
      private String description;
}
