package com.lopes.springsoap.client;

import com.lopes.springsoap.gen.GetCustomerRequest;
import com.lopes.springsoap.gen.GetCustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CustomerClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(CustomerClient.class);

    public GetCustomerResponse getCustomer(String customer) {

        GetCustomerRequest request = new GetCustomerRequest();
        request.setName(customer);

        logger.info("Requesting information for " + customer);

        GetCustomerResponse response = (GetCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}