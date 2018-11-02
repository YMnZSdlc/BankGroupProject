package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AccountHistoryCreationDto;
import pl.sda.bankserver.domain.AccountHistory;
import pl.sda.bankserver.services.AccountHistoryService;

import java.util.List;
import java.util.Map;

@RestController
public class AccountHistoryController {
    
    private AccountHistoryService accountHistoryService;

    @Autowired
    public AccountHistoryController(AccountHistoryService accountHistoryService) {
        this.accountHistoryService = accountHistoryService;
    }
    
    @PostMapping("/server/accounthistory/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccountHistory(@RequestBody AccountHistoryCreationDto creationDto) {
//        accountHistoryService.createAccountHistory(creationDto);
    }
    
    @GetMapping("/server/accounthistory/all")
    public List<AccountHistory> findAll() {
        return null;
    }
    
    @GetMapping("/server/accounthistory/find")
    public AccountHistory findAccountHistory(@RequestParam Map<String, String> customQuery) {
        return null;
    }
    
    @PutMapping("/server/accounthistory/update")
    public void updateAccountHistory(@RequestParam Map<String, String> customQuery, @RequestBody AccountHistoryCreationDto creationDto) {
//        accountHistoryService.updateAccountHistory(customQuery, creationDto);
    }
    
    @DeleteMapping("/server/accounthistory/delete")
    public void deleteAccountHistory(@RequestParam Map<String, String> customQuery) {
//        accountHistoryService.deleteAccountHistory(customQuery);
    }
}
