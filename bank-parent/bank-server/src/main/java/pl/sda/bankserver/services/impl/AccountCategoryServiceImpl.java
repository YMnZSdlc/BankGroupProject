package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.AccountCategory;
import pl.sda.bankserver.repository.AccountCategoryRepository;
import pl.sda.bankserver.services.AccountCategoryService;

import java.util.List;
import java.util.Map;

@Service
public class AccountCategoryServiceImpl implements AccountCategoryService {

    private AccountCategoryRepository accountCategoryRepository;

    @Autowired
    public AccountCategoryServiceImpl(AccountCategoryRepository accountCategoryRepository) {
        this.accountCategoryRepository = accountCategoryRepository;
    }

    @Override
    public void createAccountCategory(AccountCategoryCreationDto creationDto) {

    }

    @Override
    public List<AccountCategory> findAll() {
        return null;
    }

    @Override
    public List<AccountCategory> findAccountCategory(Map<String, String> customQuery) {
        return null;
    }

    @Override
    public void updateAccountCategory(Map<String, String> customQuery, AccountCategoryCreationDto creationDto) {

    }

    @Override
    public void deleteAccountCategory(Map<String, String> customQuery) {

    }
}
