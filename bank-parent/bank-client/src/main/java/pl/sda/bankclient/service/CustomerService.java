package pl.sda.bankclient.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;

@Component
public class CustomerService implements IService<CustomerRegistrationDto> {

    RestTemplate restTemplate = new RestTemplate();

    public CustomerRegistrationDto save(CustomerRegistrationDto dto) {
        return restTemplate.postForObject("localhost:8080/customers/save", dto, CustomerRegistrationDto.class);
    }

    public void find(CustomerRegistrationDto customerDto) {

    }
}