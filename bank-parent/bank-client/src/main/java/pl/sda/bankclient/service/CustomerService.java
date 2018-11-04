package pl.sda.bankclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.bankcommons.domain.dtos.CustomerDto;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService implements IService<CustomerDto> {

    RestTemplate restTemplate = new RestTemplate();

    public CustomerDto save(CustomerDto dto) {
        return restTemplate.postForObject("localhost:8080/customers/save", dto, CustomerDto.class);
    }

    public List<CustomerDto> findAll() {
        CustomerDto[] customerRegistrationDtos = restTemplate.getForObject("http://localhost:8080/server/customer/all", CustomerDto[].class);
        return Arrays.asList(customerRegistrationDtos);
    }

    public void find(CustomerDto customerDto) {

    }
}