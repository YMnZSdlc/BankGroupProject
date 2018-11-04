package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AccountHistoryDto;
import pl.sda.bankserver.domain.AccountHistory;

import java.util.List;
import java.util.Map;

public interface AccountHistoryService {
    void createAccountHistory(AccountHistoryDto creationDto);
    
    List<AccountHistory> findAll();
    
    List<AccountHistory> findAccountHistory(Map<String, String> customQuery);
    
    void updateAccountHistory(Map<String, String> customQuery, AccountHistoryDto creationDto);
    
    void deleteAccountHistory(Map<String, String> customQuery);
}
