package pl.sda.bankserver.mappers;

import pl.sda.bankserver.domain.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FakeDomains {

    public Account createAccount (){
        Account entity = new Account();
        entity.setId(1234);
        entity.setNumber("1234");
        entity.setCreateDate(LocalDateTime.of(2018,10,20,12,22));
        entity.setBalance(new BigDecimal("12345.6"));
        return entity;
    }


}
