package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.AccountCategory;

import java.util.List;
import java.util.Map;

@RestController
public class AccountCategoryController {
    
//    private AccountCategoryService accountCategoryService;
//
//    @Autowired
//    public AccountCategoryController(AccountCategoryService accountCategoryService) {
//        this.accountCategoryService = accountCategoryService;
//    }
    
    @PostMapping("/server/accountcategory/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccountCategory(@RequestBody AccountCategoryCreationDto creationDto) {
//        accountCategoryService.createAccountCategory();
    }
    
    @GetMapping("/server/accountcategory/all")
    public List<AccountCategory> findAll() {
        return null;
    }
    
    @GetMapping("/server/accountcategory/find")
    public AccountCategory findAccountCategory(@RequestParam Map<String, String> customQuery) {
        return null;
    }
    
    @PutMapping("/server/accountcategory/update")
    public void updateAccountCategory(@RequestBody AccountCategoryCreationDto creationDto) {
//        accountCategoryService.updateAccountCategory();
    }
    
    @DeleteMapping("/server/accountcategory/delete")
    public void deleteAccountCategory(@RequestParam Map<String, String> customQuery) {
//        accountCategoryService.deleteAccountCategory();
    }
}
