package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.AccountCategory;

import java.util.List;
import java.util.Map;

public interface AccountCategoryService {
    
    void createAccountCategory(AccountCategoryCreationDto creationDto);
    
    List<AccountCategory> findAll();
    
    List<AccountCategory> findAccountCategory(Map<String, String> customQuery);
    
    void updateAccountCategory(Map<String, String> customQuery, AccountCategoryCreationDto creationDto);
    
    void deleteAccountCategory(Map<String, String> customQuery);
}
