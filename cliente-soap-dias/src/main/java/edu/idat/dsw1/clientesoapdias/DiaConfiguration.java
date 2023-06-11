package edu.idat.dsw1.clientesoapdias;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration

public class DiaConfiguration {
    @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("edu.idat.dsw1.consumingwebservice.wsdl");
    return marshaller;
  }

  @Bean
  public CountryDia countryClient(Jaxb2Marshaller marshaller) {
    CountryDia client = new CountryDia();
    client.setDefaultUri("http://localhost:8080/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
