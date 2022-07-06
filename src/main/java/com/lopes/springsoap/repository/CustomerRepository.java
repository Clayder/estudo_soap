package com.lopes.springsoap.repository;

import com.lopes.springsoap.gen.Customer;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepository {

    private static final Map<String, Customer> customers = new HashMap<>();

    @PostConstruct
    public void initData() {
        Customer person1 = new Customer();
        person1.setName("Sueli Eduarda da Mota");
        person1.setEmail("sueli.eduarda.damota@compecia.com.br");
        person1.setTelephone("(63) 3822-3192");

        customers.put(person1.getEmail(), person1);

        Customer person2 = new Customer();
        person2.setName("Flávia Malu Monteiro");
        person2.setEmail("flavia.malu.monteiro@companhiadigital.net");
        person2.setTelephone("(91) 3695-8182");

        customers.put(person2.getEmail(), person2);

         Customer person3 = new Customer();
        person3.setName("Lucca Yuri Ian da Conceição");
        person3.setEmail("lucca_daconceicao@arbitral.com");
        person3.setTelephone("(92) 3608-9927");

        customers.put(person3.getEmail(), person3);
    }

    public Customer findCustomer(String email) {
        return customers.get(email);
    }

    public Customer saveCustomer(Customer customer) {
        customers.put(customer.getEmail(), customer);
        return customers.get(customer.getEmail());
    }

    public void removerCustomer(String email) {
        customers.remove(email, customers.get(email));
    }
}
