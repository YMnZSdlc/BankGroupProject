package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;

@Controller
public class AccountsController {

    @GetMapping("/accounts")
    public String showAccounts(){
        return "accounts";
    }

    @GetMapping("/accounts/save")
    public String viewFormToCreateAccount(Model model) {
        model.addAttribute("save", new AccountRegistrationDto());
        return "/accounts/save";
    }

    @PostMapping("/accounts/save")
    public String saveAccount(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/save";
    }

    @GetMapping("/accounts/find")
    public String viewFormToFindAccount(Model model) {
        model.addAttribute("find", new AccountRegistrationDto());
        return "accounts/find";
    }

    @PostMapping("/accounts/find")
    public String findAccount(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/find";
    }

    @GetMapping("/accounts/findall")
    public String findAllAccountsByParam(Model model) {
        model.addAttribute("findall", new AccountRegistrationDto());
        return "accounts/findall";
    }

    @PostMapping("/accounts/findall")
    public String findAllAccounts(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/findall";
    }

    @GetMapping("/accounts/update")
    public String chooseAccountForUpdate(Model model) {
        model.addAttribute("update", new AccountRegistrationDto());
        return "accounts/update";
    }

    @PutMapping("/accounts/update")
    public String updateAccount(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/update";
    }

    @GetMapping("/accounts/delete")
    public String findAccountToDelete(Model model) {
        model.addAttribute("delete", new AccountRegistrationDto());
        return "accounts/delete";
    }

    @DeleteMapping("/accounts/delete")
    public String deleteAccount(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/delete";
    }
}
