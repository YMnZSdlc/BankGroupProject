package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    public Account findAccount(@RequestParam Map<String, String> customQuery) {
        return (Account) accountService.findAccount(customQuery);
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
