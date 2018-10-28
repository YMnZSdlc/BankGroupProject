package pl.sda.bankclient.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankclient.dtos.CustomerDto;
import pl.sda.bankserver.domain.Customer;

import java.util.List;
import java.util.UUID;

@Controller
public class CustomersController {

    @GetMapping("/customers")
    public String showCustomers(){

        return "customers";
    }


    @GetMapping("/customers/save")
    public String viewFormToCreateCustomer(Model model){

        model.addAttribute("save", new CustomerDto());

        return "customers/save";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute CustomerDto customerDto){

        return "customers/save";
    }

    @GetMapping("/customers/find")
    public String viewFormToFindCustomer(Model model){

        model.addAttribute("find", new CustomerDto());

        return "customers/find";
    }

    @PostMapping("/customers/find")
    public String findCustomer(@ModelAttribute CustomerDto customerDto){


        return "customers/find";
    }



    @GetMapping("/customers/findall")
    public String findAllCustomersByParam(Model model){

        model.addAttribute("findall", new CustomerDto());

        return "customers/findall";
    }

    @PostMapping("/customers/findall")
    public String findallCustomers(@ModelAttribute CustomerDto customerDto){


        return "customers/findall";
    }


    @GetMapping("/customers/update")
    public String chooseCustomerForUpdate(Model model){

        model.addAttribute("update", new CustomerDto());

        return "customers/update";
    }

    @PutMapping("/customers/update")
    public String updateCustomer(@ModelAttribute CustomerDto customerDto){
        return "customers/update";
    }


    @GetMapping("customers/delete")
    public String findCustomerToDelete(Model model){

        model.addAttribute("delete", new CustomerDto());

        return "customers/delete";
    }

    @DeleteMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute CustomerDto customerDto){
        return "customers/delete";
    }

}
