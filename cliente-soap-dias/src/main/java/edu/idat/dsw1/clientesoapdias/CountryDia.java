package edu.idat.dsw1.clientesoapdias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import edu.idat.dsw1.clientesoapdias.wsdl.GetCountryRequest;
import edu.idat.dsw1.clientesoapdias.wsdl.GetCountryResponse;

public class CountryDia extends WebServiceGatewaySupport {
     private static final Logger log = LoggerFactory.getLogger(CountryDia.class);

  public GetCountryResponse getCountry(String country) {

    GetCountryRequest request = new GetCountryRequest();
    request.setName(country);

    log.info("Requesting location for " + country);

    GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/ws/wsec1e1", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

    return response;
  }
    
}
