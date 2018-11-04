package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.repository.AccountRepository;
import pl.sda.bankserver.services.AccountService;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(AccountDto registrationDto) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> findAccount(Map<String, String> customQuery) {
        return null;
    }

    @Override
    public void updateAccount(Map<String, String> customQuery, AccountDto registrationDto) {

    }

    @Override
    public void deleteAccount(Map<String, String> customQuery) {

    }
}
