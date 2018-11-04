package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.CustomerDto;
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
    public void createCustomer(@RequestBody @Valid CustomerDto registrationDto) {
        customerService.createCustomer(registrationDto);
    }
    
    @GetMapping("/server/customer/all")
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }
    
    @GetMapping("/server/customer/find")
    public Customer findCustomer(@RequestParam Map<String, String> customQuery) {
        return customerService.findCustomer(customQuery);
    }
    
    @PutMapping("/server/customer/update")
    public void updateCustomer(@RequestParam Map<String, String> customQuery, @RequestBody @Valid CustomerDto registrationDto) {
        customerService.updateCustomer(customQuery, registrationDto);
    }
    
    @DeleteMapping("/server/customer/delete")
    public void deleteCustomer(@RequestParam Map<String, String> customQuery) {
        customerService.deleteCustomer(customQuery);
    }
}
