package com.mx.am.microservice.farelogixws.service.domain;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mx.am.microservice.farelogixws.dao.FarelogixDAO;
import com.mx.am.microservice.farelogixws.dao.FarelogixDAOImp;
import com.mx.am.framework.exceptionhandler.exception.BusinessException;
import com.mx.am.framework.exceptionhandler.exception.ComponentException;
import com.mx.am.framework.exceptionhandler.exception.InfraestructureException;
import com.mx.am.framework.exceptionhandler.exception.ProviderException;
import com.mx.am.framework.service.ErrorManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
@SpringBootTest()
@TestPropertySource(locations = "/application-dev-test.properties")
class FarelogixServiceDaoImpTest {

      @Autowired
      @Qualifier("serviceDaoImpl")
      FarelogixService domainNameServiceDao;

      @Autowired
      MongoClient mongoClient;

      @Autowired
      ErrorManagerService errorManagerService;


      @BeforeEach
      void init() {

            ConnectionString connectionString = new ConnectionString(
                    "mongodb://" + "aeromexico" + ":" + "password" + "@" + "localhost" + ":" + "27017" + "/"
                            + "aeromexico" + "?serverSelectionTimeoutMS=0&connectTimeoutMS=0");
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                    .build();

            mongoClient = MongoClients.create(mongoClientSettings);

            MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "aeromexico");

            FarelogixDAO dao = new FarelogixDAOImp(mongoTemplate);

            domainNameServiceDao = new FarelogixServiceDaoImp(dao, errorManagerService);

      }

      @Test()
      void mongoDisconnectionTest() throws InfraestructureException, ProviderException, ComponentException, BusinessException {
            assertThrows(InfraestructureException.class, () -> domainNameServiceDao.getAllFarelogix());

      }

}