package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;
import pl.sda.bankserver.domain.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class AccountMapperTest {

    @Test
    public void accountToAccountRegistrationDto() {
        //given
        Account entity = new Account();
        entity.setId(1234);
        entity.setNumber("1234");
        entity.setCreateDate(LocalDateTime.of(2018,10,20,12,22));
        entity.setBalance(new BigDecimal("12345.6"));

        //when
        AccountRegistrationDto dto = AccountMapper.INSTANCE.accountToAccountRegistrationDto(entity);

        //then
        assertEquals(dto.getId(), entity.getId());
    }

    @Test
    public void accountRegistrationDtoToAccount() {
        //given

        //when

        //then

    }
}