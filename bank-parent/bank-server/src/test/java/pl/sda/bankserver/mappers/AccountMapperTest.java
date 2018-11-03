package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

import static org.junit.Assert.*;

public class AccountMapperTest {

    FakeDomains fakeDomains = new FakeDomains();

    @Test
    public void accountToAccountRegistrationDto() {
        //given
        Account entityIn = fakeDomains.createAccount();

        //when
        AccountDto dtoOut = AccountMapper.INSTANCE.accountToAccountRegistrationDto(entityIn);

        //then
        assertEquals(dtoOut.getId(), entityIn.getId());
        assertEquals(dtoOut.getNumber(), entityIn.getNumber());
        assertEquals(dtoOut.getCreateDate(), entityIn.getCreateDate());
        assertEquals(dtoOut.getBalance(), entityIn.getId());
        assertEquals(dtoOut.getServices(), entityIn.getId());
        assertEquals(dtoOut.getCards(), entityIn.getId());
    }

    @Test
    public void accountRegistrationDtoToAccount() {
        //given

        //when

        //then

    }
}