package pl.sda.bankclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService implements IService<CustomerRegistrationDto> {

    RestTemplate restTemplate = new RestTemplate();

    public CustomerRegistrationDto save(CustomerRegistrationDto dto) {
        return restTemplate.postForObject("localhost:8080/customers/save", dto, CustomerRegistrationDto.class);
    }

    public List<CustomerRegistrationDto> findAll() {
        CustomerRegistrationDto[] customerRegistrationDtos = restTemplate.getForObject("http://localhost:8080/server/customer/all", CustomerRegistrationDto[].class);
        return Arrays.asList(customerRegistrationDtos);
    }

    public void find(CustomerRegistrationDto customerDto) {

    }
}