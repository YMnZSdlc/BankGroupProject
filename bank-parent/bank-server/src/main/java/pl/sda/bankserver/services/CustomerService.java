package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;
import pl.sda.bankserver.domain.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    void createCustomer(CustomerRegistrationDto registrationDto);

    List<CustomerRegistrationDto> findAll();

    Customer findCustomer(Map<String, String> customQuery);

    void updateCustomer(Map<String, String> customQuery, CustomerRegistrationDto registrationDto);

    void deleteCustomer(Map<String, String> customQuery);
}
