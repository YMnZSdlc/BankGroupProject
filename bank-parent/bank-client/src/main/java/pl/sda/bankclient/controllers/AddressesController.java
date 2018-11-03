package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AddressDto;

@Controller
public class AddressesController {

    @GetMapping("/addresses")
    public String showAddresses(){
        return "addresses";
    }

    @GetMapping("/addresses/save")
    public String viewFormToCreateAddress(Model model) {
        model.addAttribute("save", new AddressDto());
        return "/addresses/save";
    }

    @PostMapping("/addresses/save")
    public String saveAddress(@ModelAttribute AddressDto addressDto) {
        return "addresses/save";
    }

    @GetMapping("/addresses/find")
    public String viewFormToFindAddress(Model model) {
        model.addAttribute("find", new AddressDto());
        return "addresses/find";
    }

    @PostMapping("/addresses/find")
    public String findAddress(@ModelAttribute AddressDto addressDto) {
        return "addresses/find";
    }

    @GetMapping("/addresses/findall")
    public String findAllAddressesByParam(Model model) {
        model.addAttribute("findall", new AddressDto());
        return "addresses/findall";
    }

    @PostMapping("/addresses/findall")
    public String findAllAddresses(@ModelAttribute AddressDto addressDto) {
        return "addresses/findall";
    }

    @GetMapping("/addresses/update")
    public String chooseAddressForUpdate(Model model) {
        model.addAttribute("update", new AddressDto());
        return "addresses/update";
    }

    @PutMapping("/addresses/update")
    public String updateAddress(@ModelAttribute AddressDto addressDto) {
        return "addresses/update";
    }

    @GetMapping("/addresses/delete")
    public String findAddressesToDelete(Model model) {
        model.addAttribute("delete", new AddressDto());
        return "addresses/delete";
    }

    @DeleteMapping("/addresses/delete")
    public String deleteAddress(@ModelAttribute AddressDto addressDto) {
        return "addresses/delete";
    }
}
