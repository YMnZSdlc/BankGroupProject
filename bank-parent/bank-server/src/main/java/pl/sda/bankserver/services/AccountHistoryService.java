package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AccountHistoryCreationDto;
import pl.sda.bankserver.domain.AccountHistory;

import java.util.List;
import java.util.Map;

public interface AccountHistoryService {
    void createAccountHistory(AccountHistoryCreationDto creationDto);
    
    List<AccountHistory> findAll();
    
    List<AccountHistory> findAccountHistory(Map<String, String> customQuery);
    
    void updateAccountHistory(Map<String, String> customQuery, AccountHistoryCreationDto creationDto);
    
    void deleteAccountHistory(Map<String, String> customQuery);
}
