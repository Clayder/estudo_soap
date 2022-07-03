package com.lopes.springsoap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CustomerClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.lopes.springsoap.client.gen");
            return marshaller;
    }

    @Bean
    public CustomerClient customerClient(Jaxb2Marshaller marshaller) {
            CustomerClient client = new CustomerClient();
            client.setDefaultUri("http://localhost:8080/ws");
            client.setMarshaller(marshaller);
            client.setUnmarshaller(marshaller);
            return client;
    }
}