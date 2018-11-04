package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

import static org.junit.Assert.*;

public class AccountMapperTest {

    private FakeDomains fakeDomains = new FakeDomains();

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
        assertEquals(dtoOut.getBalance(), entityIn.getBalance());
//        assertEquals(dtoOut.getServices(), entityIn.getServices());
//        assertEquals(dtoOut.getCards(), entityIn.getCards());
        assertEquals(dtoOut.getAccountCategoryId(), entityIn.getAccountCategory().getId());
//        assertEquals(dtoOut.getAccountHistories(), entityIn.getAccountHistories());
//        assertEquals(dtoOut.getCustomers(), entityIn.getCustomers());
    }

    @Test
    public void accountRegistrationDtoToAccount() {
        //given
        AccountDto dto = FakeDtos.createAccountDto();
        //when
        Account entity = AccountMapper.INSTANCE.accountRegistrationDtoToAccount(dto);
        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getNumber(), dto.getNumber());
        assertEquals(entity.getCreateDate(), dto.getCreateDate());
        assertEquals(entity.getBalance(), dto.getBalance());
//        assertEquals(entity.getServices(), dto.getServices());
//        assertEquals(entity.getCreateDate(), dto.getCreateDate());
        assertEquals(entity.getCards(), dto.getCards());
        assertEquals(entity.getAccountCategory().getId(), dto.getAccountCategoryId());
        assertEquals(entity.getAccountHistories(), dto.getAccountHistories());
    }
}