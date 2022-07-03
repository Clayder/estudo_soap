package com.lopes.springsoap;

import com.lopes.springsoap.gen.Currency;
import com.lopes.springsoap.gen.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepository {

    private static final Map<String, Customer> customers = new HashMap<>();

    @PostConstruct
    public void initData() {
        Customer spain = new Customer();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        customers.put(spain.getName(), spain);

        Customer poland = new Customer();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        customers.put(poland.getName(), poland);

        Customer uk = new Customer();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        customers.put(uk.getName(), uk);
    }

    public Customer findCustomer(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return customers.get(name);
    }
}
