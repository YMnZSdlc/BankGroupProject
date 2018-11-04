package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AccountCategoryDto;
import pl.sda.bankserver.domain.AccountCategory;

import java.util.List;
import java.util.Map;

public interface AccountCategoryService {
    
    void createAccountCategory(AccountCategoryDto creationDto);
    
    List<AccountCategory> findAll();
    
    List<AccountCategory> findAccountCategory(Map<String, String> customQuery);
    
    void updateAccountCategory(Map<String, String> customQuery, AccountCategoryDto creationDto);
    
    void deleteAccountCategory(Map<String, String> customQuery);
}
