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
    public String viewFormToCreateAccounts(Model model) {
        model.addAttribute("save", new AccountRegistrationDto());
        return "/accounts/save";
    }

    @PostMapping("/accounts/save")
    public String saveAccounts(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/save";
    }

    @GetMapping("/accounts/find")
    public String viewFormToFindAccounts(Model model) {
        model.addAttribute("find", new AccountRegistrationDto());
        return "accounts/find";
    }

    @PostMapping("/accounts/find")
    public String findAccounts(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
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
    public String chooseAccountsForUpdate(Model model) {
        model.addAttribute("update", new AccountRegistrationDto());
        return "accounts/update";
    }

    @PutMapping("/accounts/update")
    public String updateAccounts(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/update";
    }

    @GetMapping("/accounts/delete")
    public String findAccountsToDelete(Model model) {
        model.addAttribute("delete", new AccountRegistrationDto());
        return "accounts/delete";
    }

    @DeleteMapping("/accounts/delete")
    public String deleteAccounts(@ModelAttribute AccountRegistrationDto accountRegistrationDto) {
        return "accounts/delete";
    }
}
