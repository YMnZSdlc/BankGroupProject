package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.CustomerDto;
import pl.sda.bankserver.domain.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    void createCustomer(CustomerDto registrationDto);

    List<Customer> findAll();

    Customer findCustomer(Map<String, String> customQuery);

    void updateCustomer(Map<String, String> customQuery, CustomerDto registrationDto);

    void deleteCustomer(Map<String, String> customQuery);
}
