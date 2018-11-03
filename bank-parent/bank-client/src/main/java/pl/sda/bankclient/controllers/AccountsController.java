package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AccountDto;

@Controller
public class AccountsController {

    @GetMapping("/accounts")
    public String showAccounts(){
        return "accounts";
    }

    @GetMapping("/accounts/save")
    public String viewFormToCreateAccount(Model model) {
        model.addAttribute("save", new AccountDto());
        return "/accounts/save";
    }

    @PostMapping("/accounts/save")
    public String saveAccount(@ModelAttribute AccountDto accountDto) {
        return "accounts/save";
    }

    @GetMapping("/accounts/find")
    public String viewFormToFindAccount(Model model) {
        model.addAttribute("find", new AccountDto());
        return "accounts/find";
    }

    @PostMapping("/accounts/find")
    public String findAccount(@ModelAttribute AccountDto accountDto) {
        return "accounts/find";
    }

    @GetMapping("/accounts/findall")
    public String findAllAccountsByParam(Model model) {
        model.addAttribute("findall", new AccountDto());
        return "accounts/findall";
    }

    @PostMapping("/accounts/findall")
    public String findAllAccounts(@ModelAttribute AccountDto accountDto) {
        return "accounts/findall";
    }

    @GetMapping("/accounts/update")
    public String chooseAccountForUpdate(Model model) {
        model.addAttribute("update", new AccountDto());
        return "accounts/update";
    }

    @PutMapping("/accounts/update")
    public String updateAccount(@ModelAttribute AccountDto accountDto) {
        return "accounts/update";
    }

    @GetMapping("/accounts/delete")
    public String findAccountToDelete(Model model) {
        model.addAttribute("delete", new AccountDto());
        return "accounts/delete";
    }

    @DeleteMapping("/accounts/delete")
    public String deleteAccount(@ModelAttribute AccountDto accountDto) {
        return "accounts/delete";
    }
}
