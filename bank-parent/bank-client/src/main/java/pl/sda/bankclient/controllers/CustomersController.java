package pl.sda.bankclient.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankclient.service.IService;
import pl.sda.bankcommons.domain.dtos.CustomerDto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomersController {

    IService<CustomerDto> customerService;

    @Autowired
    public CustomersController(IService<CustomerDto> customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String showCustomers() {
        return "customers";
    }

    @GetMapping("/customers/save")
    public String viewFormToCreateCustomer(Model model) {
        model.addAttribute("save", new CustomerDto());
        return "customers/save";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute CustomerDto customerDto) {
        customerService.save(customerDto);
        return "customers/save";
    }

    @GetMapping("/customers/find")
    public String viewFormToFindCustomer(Model model) {
        model.addAttribute("find", new CustomerDto());
        return "customers/find";
    }

    @PostMapping("/customers/find")
    public String findCustomer(@ModelAttribute CustomerDto customerDto) {
        customerService.find(customerDto);
        return "customers/find";
    }

    @GetMapping("/customers/findall")
    public String findAllCustomersByParam(Model model) {
        List<CustomerDto> list = new ArrayList<CustomerDto>();
        model.addAttribute("findall", list);
        return "customers/findall";
    }

    @GetMapping("/customers/update")
    public String chooseCustomerForUpdate(Model model) {
        model.addAttribute("update", new CustomerDto());
        return "customers/update";
    }

    @PutMapping("/customers/update")
    public String updateCustomer(@ModelAttribute CustomerDto customerDto) {
        return "customers/update";
    }

    @GetMapping("customers/delete")
    public String findCustomerToDelete(Model model) {
        model.addAttribute("delete", new CustomerDto());
        return "customers/delete";
    }

    @DeleteMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute CustomerDto customerDto) {
        return "customers/delete";
    }
}
