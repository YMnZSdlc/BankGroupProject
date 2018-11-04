package pl.sda.bankclient.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.sda.bankclient.service.IService;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;

@Controller
public class CustomersController {

    IService<CustomerRegistrationDto> customerService;

    @Autowired
    public CustomersController(IService<CustomerRegistrationDto> customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String showCustomers() {
        return "customers";
    }

    @GetMapping("/customers/save")
    public String viewFormToCreateCustomer(Model model) {
        model.addAttribute("save", new CustomerRegistrationDto());
        return "customers/save";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute CustomerRegistrationDto customerDto) {
        customerService.save(customerDto);
        return "customers/save";
    }

    @GetMapping("/customers/find")
    public String viewFormToFindCustomer(Model model) {
        model.addAttribute("find", new CustomerRegistrationDto());
        return "customers/find";
    }

    @PostMapping("/customers/find")
    public String findCustomer(@ModelAttribute CustomerRegistrationDto customerDto) {
        customerService.find(customerDto);
        return "customers/find";
    }

    @GetMapping("/customers/findall")
    public String findAllCustomersByParam(Model model) {
        model.addAttribute("findall", customerService.findAll());
        return "customers/findall";
    }
//
//    @PostMapping("/customers/findall")
//    public String findAllCustomers(Model model) {
//        model.addAttribute("findall", customerService.findAll());
//        return "customers/findall";
//    }

    @GetMapping("/customers/update")
    public String chooseCustomerForUpdate(Model model) {
        model.addAttribute("update", new CustomerRegistrationDto());
        return "customers/update";
    }

    @PutMapping("/customers/update")
    public String updateCustomer(@ModelAttribute CustomerRegistrationDto customerDto) {
        return "customers/update";
    }

    @GetMapping("customers/delete")
    public String findCustomerToDelete(Model model) {
        model.addAttribute("delete", new CustomerRegistrationDto());
        return "customers/delete";
    }

    @DeleteMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute CustomerRegistrationDto customerDto) {
        return "customers/delete";
    }
}
