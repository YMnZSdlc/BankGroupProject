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
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.AccountCategory;
import pl.sda.bankserver.services.AccountCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class AccountCategoryController {

    private AccountCategoryService accountCategoryService;

    @Autowired
    public AccountCategoryController(AccountCategoryService accountCategoryService) {
        this.accountCategoryService = accountCategoryService;
    }
    
    @PostMapping("/server/accountcategory/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccountCategory(@RequestBody @Valid AccountCategoryCreationDto creationDto) {
//        accountCategoryService.createAccountCategory(creationDto);
    }
    
    @GetMapping("/server/accountcategory/all")
    public List<AccountCategory> findAll() {
        return accountCategoryService.findAll();
    }
    
    @GetMapping("/server/accountcategory/find")
    public List<AccountCategory> findAccountCategory(@RequestParam Map<String, String> customQuery) {
        return accountCategoryService.findAccountCategory(customQuery);
    }
    
    @PutMapping("/server/accountcategory/update")
    public void updateAccountCategory(@RequestParam Map<String, String> customQuery, @RequestBody @Valid
            AccountCategoryCreationDto creationDto) {
        accountCategoryService.updateAccountCategory(customQuery, creationDto);
    }
    
    @DeleteMapping("/server/accountcategory/delete")
    public void deleteAccountCategory(@RequestParam Map<String, String> customQuery) {
        accountCategoryService.deleteAccountCategory(customQuery);
    }
}
