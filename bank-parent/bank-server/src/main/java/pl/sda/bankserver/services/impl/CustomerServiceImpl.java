package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.CustomerDto;
import pl.sda.bankserver.domain.Customer;
import pl.sda.bankserver.repository.CustomerRepository;
import pl.sda.bankserver.services.CustomerService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(CustomerDto registrationDto) {

    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> all = customerRepository.findAll();
        return all.stream().map(this::toDto).collect(Collectors.toList());
    }

    private CustomerDto toDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPesel(customer.getPesel());
        return dto;
    }

    @Override
    public Customer findCustomer(Map<String, String> customQuery) {
        return null;
    }

    @Override
    public void updateCustomer(Map<String, String> customQuery, CustomerDto registrationDto) {

    }

    @Override
    public void deleteCustomer(Map<String, String> customQuery) {

    }
}
