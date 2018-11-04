package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

import static org.junit.Assert.*;

public class AccountMapperTest {

    FakeDtos fakeDtos = new FakeDtos();

    @Test
    public void accountToAccountDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        Account entityIn = fakeDomains.getAccount();

        //when
        AccountDto dtoOut = AccountMapper.INSTANCE.accountToAccountRegistrationDto(entityIn);

        //then
        assertEquals(dtoOut.getId(), entityIn.getId());
        assertEquals(dtoOut.getNumber(), entityIn.getNumber());
        assertEquals(dtoOut.getCreateDate(), entityIn.getCreateDate());
        assertEquals(dtoOut.getBalance(), entityIn.getBalance());
        assertEquals(dtoOut.getServices().get(0).getId(), entityIn.getServices().get(0).getId());
//        assertEquals(dtoOut.getCards(), entityIn.getCards());
//        assertEquals(dtoOut.getAccountCategoryId(), entityIn.getAccountCategory());
//        assertEquals(dtoOut.getAccountHistories(), entityIn.getAccountHistories());
    }

    @Test
    public void accountRegistrationDtoToAccount() {
        //given
        AccountDto dtoIn = fakeDtos.createAccountDto();

        //when
        Account entityOut = AccountMapper.INSTANCE.accountRegistrationDtoToAccount(dtoIn);

        //then
        assertEquals(entityOut.getId(), dtoIn.getId());
        assertEquals(entityOut.getNumber(), dtoIn.getNumber());
        assertEquals(entityOut.getCreateDate(), dtoIn.getCreateDate());
        assertEquals(entityOut.getBalance(), dtoIn.getBalance());
        assertEquals(entityOut.getServices().get(0).getDate(), dtoIn.getServices().get(0).getDate());
        assertEquals(entityOut.getCards().get(0).getCardNo(), dtoIn.getCards().get(0).getCardNo());
        assertEquals(entityOut.getAccountCategory().getId(), dtoIn.getAccountCategoryId());
        assertEquals(entityOut.getAccountHistories().get(0).getId(), dtoIn.getAccountHistories().get(0).getId());
    }
}