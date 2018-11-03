package pl.sda.bankclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.bankcommons.domain.dtos.CustomerDto;

@Component
public class CustomerService implements IService<CustomerDto> {

    @Autowired
    RestTemplate restTemplate;

    public CustomerDto save(CustomerDto entity) {
        return restTemplate.postForObject("localhost:8080/customers/save", entity, CustomerDto.class);
    }

}
