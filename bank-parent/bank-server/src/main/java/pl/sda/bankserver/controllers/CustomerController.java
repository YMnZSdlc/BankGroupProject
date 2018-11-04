package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;
import pl.sda.bankserver.domain.Customer;
import pl.sda.bankserver.services.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping("/server/customer/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody @Valid CustomerRegistrationDto registrationDto) {
        customerService.createCustomer(registrationDto);
    }
    
    @GetMapping("/server/customer/all")
    public List<CustomerRegistrationDto> findAll() {
        return customerService.findAll();
    }
    
    @GetMapping("/server/customer/find")
    public Customer findCustomer(@RequestParam Map<String, String> customQuery) {
        return customerService.findCustomer(customQuery);
    }
    
    @PutMapping("/server/customer/update")
    public void updateCustomer(@RequestParam Map<String, String> customQuery, @RequestBody @Valid CustomerRegistrationDto registrationDto) {
        customerService.updateCustomer(customQuery, registrationDto);
    }
    
    @DeleteMapping("/server/customer/delete")
    public void deleteCustomer(@RequestParam Map<String, String> customQuery) {
        customerService.deleteCustomer(customQuery);
    }
}
