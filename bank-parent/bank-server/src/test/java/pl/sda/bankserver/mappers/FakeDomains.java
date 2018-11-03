package pl.sda.bankserver.mappers;

import pl.sda.bankserver.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FakeDomains {

    FakeDomains fakeDomains = new FakeDomains();

    public Account createAccount() {
        Account account = new Account();
        account.setId(1234);
        account.setNumber("1234");
        account.setCreateDate(LocalDateTime.of(2018, 10, 20, 12, 22));
        account.setBalance(new BigDecimal("12345.6"));

        return account;
    }

    public AccountCategory createAccountCategory() {
        AccountCategory accountCategory = new AccountCategory();
        accountCategory.setId(1234);
        accountCategory.setCategoryName("1234");
        Account account = fakeDomains.createAccount();
        accountCategory.setAccount(account);

        return accountCategory;
    }

    public AccountHistory createAccountHistory() {
        AccountHistory accountHistory = new AccountHistory();
        return accountHistory;
    }

    public Address createAddress() {
        Address address = new Address();

        return address;
    }

}
