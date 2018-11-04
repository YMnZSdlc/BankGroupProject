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
import pl.sda.bankcommons.domain.dtos.AccountHistoryCreationDto;
import pl.sda.bankserver.domain.AccountHistory;
import pl.sda.bankserver.services.AccountHistoryService;

import javax.validation.Valid;
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
    public void createAccountHistory(@RequestBody @Valid AccountHistoryCreationDto creationDto) {
        accountHistoryService.createAccountHistory(creationDto);
    }

    @GetMapping("/server/accounthistory/all")
    public List<AccountHistory> findAll() {
        return null;
    }

    @GetMapping("/server/accounthistory/find")
    public List<AccountHistory> findAccountHistory(@RequestParam Map<String, String> customQuery) {
        return accountHistoryService.findAccountHistory(customQuery);
    }

    @PutMapping("/server/accounthistory/update")
    public void updateAccountHistory(@RequestParam Map<String, String> customQuery, @RequestBody @Valid AccountHistoryCreationDto creationDto) {
        accountHistoryService.updateAccountHistory(customQuery, creationDto);
    }

    @DeleteMapping("/server/accounthistory/delete")
    public void deleteAccountHistory(@RequestParam Map<String, String> customQuery) {
        accountHistoryService.deleteAccountHistory(customQuery);
    }
}
