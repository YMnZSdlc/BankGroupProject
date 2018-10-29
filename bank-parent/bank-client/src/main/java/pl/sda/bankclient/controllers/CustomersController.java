package pl.sda.bankclient.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.CustomerRegistrationDto;

@Controller
public class CustomersController {

    @GetMapping("/customers")
    public String showCustomers(){

        return "customers";
    }


    @GetMapping("/customers/save")
    public String viewFormToCreateCustomer(Model model){

        model.addAttribute("save", new CustomerRegistrationDto());

        return "customers/save";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute CustomerRegistrationDto customerDto){

        return "customers/save";
    }

    @GetMapping("/customers/find")
    public String viewFormToFindCustomer(Model model){

        model.addAttribute("find", new CustomerRegistrationDto());

        return "customers/find";
    }

    @PostMapping("/customers/find")
    public String findCustomer(@ModelAttribute CustomerRegistrationDto customerDto){


        return "customers/find";
    }



    @GetMapping("/customers/findall")
    public String findAllCustomersByParam(Model model){

        model.addAttribute("findall", new CustomerRegistrationDto());

        return "customers/findall";
    }

    @PostMapping("/customers/findall")
    public String findallCustomers(@ModelAttribute CustomerRegistrationDto customerDto){


        return "customers/findall";
    }


    @GetMapping("/customers/update")
    public String chooseCustomerForUpdate(Model model){

        model.addAttribute("update", new CustomerRegistrationDto());

        return "customers/update";
    }

    @PutMapping("/customers/update")
    public String updateCustomer(@ModelAttribute CustomerRegistrationDto customerDto){
        return "customers/update";
    }


    @GetMapping("customers/delete")
    public String findCustomerToDelete(Model model){

        model.addAttribute("delete", new CustomerRegistrationDto());

        return "customers/delete";
    }

    @DeleteMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute CustomerRegistrationDto customerDto){
        return "customers/delete";
    }

}
