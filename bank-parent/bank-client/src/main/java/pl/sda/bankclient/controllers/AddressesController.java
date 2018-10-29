package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AddressRegistrationDto;

@Controller
public class AddressesController {

    @GetMapping("/addresses")
    public String showAddresses(){
        return "accounts";
    }

    @GetMapping("/addresses/save")
    public String viewFormToCreateAddresses(Model model) {
        model.addAttribute("save", new AddressRegistrationDto());
        return "/addresses/save";
    }

    @PostMapping("/addresses/save")
    public String saveAddresses(@ModelAttribute AddressRegistrationDto addressRegistrationDto) {
        return "addresses/save";
    }

    @GetMapping("/addresses/find")
    public String viewFormToFindAddresses(Model model) {
        model.addAttribute("find", new AddressRegistrationDto());
        return "addresses/find";
    }

    @PostMapping("/addresses/find")
    public String findAddresses(@ModelAttribute AddressRegistrationDto addressRegistrationDto) {
        return "addresses/find";
    }

    @GetMapping("/addresses/findall")
    public String findAllAddressesByParam(Model model) {
        model.addAttribute("findall", new AddressRegistrationDto());
        return "addresses/findall";
    }

    @PostMapping("/addresses/findall")
    public String findAllAddresses(@ModelAttribute AddressRegistrationDto addressRegistrationDto) {
        return "accounts/findall";
    }

    @GetMapping("/addresses/update")
    public String chooseAddressesForUpdate(Model model) {
        model.addAttribute("update", new AddressRegistrationDto());
        return "addresses/update";
    }

    @PutMapping("/addresses/update")
    public String updateAddresses(@ModelAttribute AddressRegistrationDto addressRegistrationDto) {
        return "addresses/update";
    }

    @GetMapping("/addresses/delete")
    public String findAddressesToDelete(Model model) {
        model.addAttribute("delete", new AddressRegistrationDto());
        return "addresses/delete";
    }

    @DeleteMapping("/addresses/delete")
    public String deleteAddresses(@ModelAttribute AddressRegistrationDto addressRegistrationDto) {
        return "addresses/delete";
    }
}
