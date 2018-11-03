package pl.sda.bankclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;

@Component
public class CustomerService implements IService<CustomerRegistrationDto> {

    @Autowired
    RestTemplate restTemplate;

    public CustomerRegistrationDto save(CustomerRegistrationDto entity) {
        return restTemplate.postForObject("localhost:8080/customers/save", entity, CustomerRegistrationDto.class);
    }

}
