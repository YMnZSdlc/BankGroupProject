package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;
import pl.sda.bankserver.domain.Customer;
import pl.sda.bankserver.services.CustomerService;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerService customerService;
    
    @Autowired
    public CustomerServiceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @Override
    public void createCustomer(CustomerRegistrationDto registrationDto) {
    
    }
    
    @Override
    public List<Customer> findAll() {
        return null;
    }
    
    @Override
    public List<Customer> findCustomer(Map<String, String> customQuery) {
        return null;
    }
    
    @Override
    public void updateCustomer(Map<String, String> customQuery, CustomerRegistrationDto registrationDto) {
    
    }
    
    @Override
    public void deleteCustomer(Map<String, String> customQuery) {
    
    }
}
