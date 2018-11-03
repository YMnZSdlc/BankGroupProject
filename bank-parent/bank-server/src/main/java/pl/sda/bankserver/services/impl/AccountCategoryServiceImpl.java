package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.AccountCategory;
import pl.sda.bankserver.repository.AccountCategoryRepository;
import pl.sda.bankserver.repository.AccountRepository;
import pl.sda.bankserver.services.AccountCategoryService;

import java.util.List;
import java.util.Map;

@Service
public class AccountCategoryServiceImpl implements AccountCategoryService {
    
    private AccountCategoryRepository accountCategoryRepository;
    
    @Autowired
    public AccountCategoryServiceImpl(AccountCategoryRepository accountCategoryRepository) {
        this.accountCategoryRepository=accountCategoryRepository;
    }
    
    @Override
    public void createAccountCategory(AccountCategoryCreationDto creationDto) {
    AccountCategory accountCategory=AccountCategory.builder()
            .categoryName(creationDto.getCategoryName())
            .build();
    accountCategoryRepository.saveAndFlush(accountCategory);
    }
    
    @Override
    public List<AccountCategory> findAll() {
        return accountCategoryRepository.findAll();
    }
    
    @Override
    public List<AccountCategory> findAccountCategory(Map<String, String> customQuery) {
        String categoryName=customQuery.get("categoryName");
        return accountCategoryRepository.findAllByCategoryName(categoryName);
    }
    
    @Override
    public void updateAccountCategory(Map<String, String> customQuery, AccountCategoryCreationDto creationDto) {
        AccountCategory accountCategory = findAccountCategory(customQuery).get(0);
        accountCategory = AccountCategory.builder()
                .categoryName(creationDto.getCategoryName())
                .build();
        accountCategoryRepository.save(accountCategory);
    }
    
    @Override
    public void deleteAccountCategory(Map<String, String> customQuery) {
    AccountCategory accountCategory=findAccountCategory(customQuery).get(0);
    accountCategoryRepository.delete(accountCategory);
    }
}
