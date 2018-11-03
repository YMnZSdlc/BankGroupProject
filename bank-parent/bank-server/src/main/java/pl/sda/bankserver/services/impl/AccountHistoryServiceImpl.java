package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AccountHistoryCreationDto;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.domain.AccountHistory;
import pl.sda.bankserver.repository.AccountHistoryRepository;
import pl.sda.bankserver.services.AccountHistoryService;

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
    
    //@Override
    //public List<AccountHistory> findAccountHistory(Integer id){
      //  return accountHistoryRepository.findAllById(id);
    //}
    
    @Override
    public void updateAccountHistory(Map<String, String> customQuery, AccountHistoryCreationDto creationDto) {
    }
    
    @Override
    public void deleteAccountHistory(Map<String, String> customQuery) {
    }
}
