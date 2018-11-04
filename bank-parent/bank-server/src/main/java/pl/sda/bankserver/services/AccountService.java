package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
    void createAccount(AccountDto registrationDto);
    
    List<Account> findAll();
    
    List<Account> findAccount(Map<String, String> customQuery);
    
    void updateAccount(Map<String, String> customQuery, AccountDto registrationDto);
    
    void deleteAccount(Map<String, String> customQuery);
}
