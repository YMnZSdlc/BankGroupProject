package pl.sda.bankclient;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankclient.dtos.CustomerDto;

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
    public String findAllCustomersByParam(){

        return "customers/findall";
    }

    @DeleteMapping("customers/delete/{customerId}")
    public String deleteCustomer(@PathVariable String customerId){

        return "customers";
    }

}
