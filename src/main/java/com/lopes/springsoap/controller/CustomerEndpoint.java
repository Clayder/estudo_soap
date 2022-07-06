package com.lopes.springsoap.controller;

import com.lopes.springsoap.gen.AddCustomerRequest;
import com.lopes.springsoap.gen.AddCustomerResponse;
import com.lopes.springsoap.gen.Customer;
import com.lopes.springsoap.gen.GetCustomerRequest;
import com.lopes.springsoap.gen.GetCustomerResponse;
import com.lopes.springsoap.gen.RemoveCustomerRequest;
import com.lopes.springsoap.gen.RemoveCustomerResponse;
import com.lopes.springsoap.gen.ServiceStatus;
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
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customerRepository.findCustomer(request.getEmail()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCustomerRequest")
	@ResponsePayload
	public AddCustomerResponse addCustomer(@RequestPayload AddCustomerRequest request) {
        Customer newCustomer = customerRepository.saveCustomer(request.getCustomer());
        AddCustomerResponse response = new AddCustomerResponse();
        response.setCustomer(newCustomer);
        return response;
	}

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeCustomerRequest")
	@ResponsePayload
	public RemoveCustomerResponse removeCustomer(@RequestPayload RemoveCustomerRequest request) {
        customerRepository.removerCustomer(request.getEmail());
        ServiceStatus status = new ServiceStatus();
        status.setStatusCode("success");
        status.setMessage("Client successfully deleted.");
        RemoveCustomerResponse response = new RemoveCustomerResponse();
        response.setServiceStatus(status);
        return response;
	}
}
