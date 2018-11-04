package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AccountHistoryCreationDto;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.domain.AccountHistory;
import pl.sda.bankserver.repository.AccountHistoryRepository;
import pl.sda.bankserver.services.AccountHistoryService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class AccountHistoryServiceImpl implements AccountHistoryService {
    
    private AccountHistoryRepository accountHistoryRepository;
    
    @Autowired
    public AccountHistoryServiceImpl(AccountHistoryRepository accountHistoryRepository) {
        this.accountHistoryRepository = accountHistoryRepository;
    }
    
    @Override
    public void createAccountHistory(AccountHistoryCreationDto creationDto) {
    AccountHistory accountHistory=AccountHistory.builder()
            .balanceBefore(creationDto.getBalanceBefore())
            .balanceAfter(creationDto.getBalanceAfter())
            .build();
    accountHistoryRepository.saveAndFlush(accountHistory);
    }
    
    @Override
    public List<AccountHistory> findAll() {
        return accountHistoryRepository.findAll();
    }
    
    @Override
    public List<AccountHistory> findAccountHistory(Map<String, String> customQuery){
        String balanceBefore = customQuery.get("balanceBefore");
        String balanceAfter = customQuery.get("balanceAfter");
        return accountHistoryRepository.findByBalanceBeforeGreaterThanEqualAndBalanceAfterLessThanEqual(balanceBefore, balanceAfter);
    }
    
    @Override
    public void updateAccountHistory(Map<String, String> customQuery, AccountHistoryCreationDto creationDto) {
        AccountHistory accountHistory = findAccountHistory(customQuery).get(0);
        accountHistory = AccountHistory.builder()
                .balanceBefore(new BigDecimal(10000))
                .balanceAfter(new BigDecimal(12000))
                .build();
        accountHistoryRepository.save(accountHistory);
    }
    
    @Override
    public void deleteAccountHistory(Map<String, String> customQuery) {
        AccountHistory accountHistory = findAccountHistory(customQuery).get(0);
        accountHistoryRepository.delete(accountHistory);
    }
}
