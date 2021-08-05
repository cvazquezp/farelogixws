package com.mx.am.microservice.farelogixws.repository;

import com.mx.am.microservice.farelogixws.entity.Farelogix;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FarelogixRepository extends MongoRepository<Farelogix, ObjectId> {
      @Override
      List<Farelogix> findAll();
}
