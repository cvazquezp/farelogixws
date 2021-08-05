package com.mx.am.microservice.farelogixws.dao;


import com.mx.am.microservice.farelogixws.entity.Farelogix;

import java.net.ConnectException;
import java.util.List;

public interface FarelogixDAO {
      List<Farelogix> getAll() throws ConnectException;
}
