package com.lopes.springsoap.controller;

import com.lopes.springsoap.gen.GetCustomerRequest;
import com.lopes.springsoap.gen.GetCustomerResponse;
import com.lopes.springsoap.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerEndpoint {

    private static final String NAMESPACE_URI = "http://www.lopes.com/springsoap/gen";

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
        System.out.println("@@@@@@@@@");
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customerRepository.findCustomer(request.getEmail()));

        return response;
    }
}
