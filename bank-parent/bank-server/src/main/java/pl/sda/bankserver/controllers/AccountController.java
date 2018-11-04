package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.services.AccountService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/server/account/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody @Valid AccountRegistrationDto registrationDto) {
        accountService.createAccount(registrationDto);
    }

    @GetMapping("/server/account/all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/server/account/find")
    public List<Account> findAccount(@RequestParam Map<String, String> customQuery) {
        return accountService.findAccount(customQuery);
    }

    @PutMapping("/server/account/update")
    public void updateAccount(@RequestParam Map<String, String> customQuery, @RequestBody @Valid AccountRegistrationDto registrationDto) {
        accountService.updateAccount(customQuery, registrationDto);
    }

    @DeleteMapping("/server/account/delete")
    public void deleteAccount(@RequestParam Map<String, String> customQuery) {
        accountService.deleteAccount(customQuery);
    }
}
