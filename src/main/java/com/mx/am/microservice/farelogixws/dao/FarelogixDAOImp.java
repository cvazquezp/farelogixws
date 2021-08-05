package com.mx.am.microservice.farelogixws.dao;


import com.mx.am.microservice.farelogixws.entity.Farelogix;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.net.ConnectException;
import java.util.List;


@Component
public class FarelogixDAOImp implements FarelogixDAO {
      private final MongoTemplate mongoTemplate;

      public FarelogixDAOImp(MongoTemplate mongoTemplate) {
            this.mongoTemplate = mongoTemplate;
      }

      @Override
      public List<Farelogix> getAll() throws ConnectException {
            List<Farelogix> list;
            try {
                  list = mongoTemplate.findAll(Farelogix.class);
            } catch (Exception e) {
                  throw new ConnectException(e.getLocalizedMessage());

            }
            return list;
      }
}
