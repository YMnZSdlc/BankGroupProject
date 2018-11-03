package pl.sda.bankclient.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.sda.bankclient.service.CustomerService;
import pl.sda.bankcommons.domain.dtos.CustomerDto;

@Controller
public class CustomersController {

    @Autowired
    CustomerService customerService;

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
        //TODO
        return "customers/save";
    }

    @GetMapping("/customers/find")
    public String viewFormToFindCustomer(Model model) {
        model.addAttribute("find", new CustomerDto());
        return "customers/find";
    }

    @PostMapping("/customers/find")
    public String findCustomer(@ModelAttribute CustomerDto customerDto) {
        return "customers/find";
    }

    @GetMapping("/customers/findall")
    public String findAllCustomersByParam(Model model) {
        model.addAttribute("findall", new CustomerDto());
        return "customers/findall";
    }

    @PostMapping("/customers/findall")
    public String findAllCustomers(@ModelAttribute CustomerDto customerDto) {
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
