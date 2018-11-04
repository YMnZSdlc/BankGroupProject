package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;
import pl.sda.bankserver.domain.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
    void createAccount(AccountRegistrationDto registrationDto);
    
    List<Account> findAll();
    
    List<Account> findAccount(Map<String, String> customQuery);
    
    void updateAccount(Map<String, String> customQuery, AccountRegistrationDto registrationDto);
    
    void deleteAccount(Map<String, String> customQuery);
}
