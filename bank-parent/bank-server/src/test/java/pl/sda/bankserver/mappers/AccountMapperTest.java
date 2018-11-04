package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

import static org.junit.Assert.*;

public class AccountMapperTest {

    FakeDomains fakeDomains = new FakeDomains();
    FakeDtos fakeDtos = new FakeDtos();

    @Test
    public void accountToAccountDto() {
        //given
        Account entityIn = fakeDomains.createAccount();

        //when
        AccountDto dtoOut = AccountMapper.INSTANCE.accountToAccountRegistrationDto(entityIn);

        //then
        assertEquals(dtoOut.getId(), entityIn.getId());
        assertEquals(dtoOut.getNumber(), entityIn.getNumber());
        assertEquals(dtoOut.getCreateDate(), entityIn.getCreateDate());
        assertEquals(dtoOut.getBalance(), entityIn.getBalance());
        assertEquals(dtoOut.getServices(), entityIn.getServices());
        assertEquals(dtoOut.getCards(), entityIn.getCards());
        assertEquals(dtoOut.getAccountCategoryId(), entityIn.getAccountCategory());
        assertEquals(dtoOut.getAccountHistories(), entityIn.getAccountHistories());
    }

    @Test
    public void accountDtoToAccount() {
        //given
        AccountDto dtoIn = fakeDtos.createAccountDto();

        //when
        Account entityOut = AccountMapper.INSTANCE.accountRegistrationDtoToAccount(dtoIn);

        //then
        assertEquals(entityOut.getId(), dtoIn.getId());
        assertEquals(entityOut.getNumber(), dtoIn.getNumber());
        assertEquals(entityOut.getCreateDate(), dtoIn.getCreateDate());
        assertEquals(entityOut.getBalance(), dtoIn.getBalance());
        assertEquals(entityOut.getServices(), dtoIn.getServices());
        assertEquals(entityOut.getCards(), dtoIn.getCards());
        assertEquals(entityOut.getAccountCategory(), dtoIn.getAccountCategoryId());
        assertEquals(entityOut.getAccountHistories(), dtoIn.getAccountHistories());
    }
}