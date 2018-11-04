package pl.sda.bankclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;

@Service
public class CustomerService implements IService<CustomerRegistrationDto> {

    RestTemplate restTemplate = new RestTemplate();

    public CustomerRegistrationDto save(CustomerRegistrationDto dto) {
        return restTemplate.postForObject("localhost:8080/customers/save", dto, CustomerRegistrationDto.class);
    }

    public void find(CustomerRegistrationDto customerDto) {

    }
}