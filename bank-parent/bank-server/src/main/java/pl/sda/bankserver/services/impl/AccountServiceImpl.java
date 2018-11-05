package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.repository.AccountRepository;
import pl.sda.bankserver.services.AccountService;

import java.math.BigDecimal;
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
    public void createAccount(AccountRegistrationDto registrationDto) {
        Account account = Account.builder()
                .number(registrationDto.getNumber())
                .createDate(registrationDto.getCreateDate())
                .balance(registrationDto.getBalance())
                .build();
        accountRepository.saveAndFlush(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAccount(Map<String, String> customQuery) {
        String number = customQuery.get("number");
        return accountRepository.findAllByNumber(number);
    }

    @Override
    public void updateAccount(Map<String, String> customQuery, AccountRegistrationDto registrationDto) {

    }

    @Override
    public void deleteAccount(Map<String, String> customQuery) {

    }
}
