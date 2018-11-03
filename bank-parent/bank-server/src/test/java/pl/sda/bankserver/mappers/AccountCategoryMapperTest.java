package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.domain.AccountCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class AccountCategoryMapperTest {

    @Test
    public void accountCategoryToAccountCategoryCreationDto() {
        //given
        Account account = new Account();
        account.setId(1234);
        account.setNumber("1234");
        account.setCreateDate(LocalDateTime.of(2018,10,20,12,22));
        account.setBalance(new BigDecimal("12345.6"));

        AccountCategory entity = new AccountCategory();
        entity.setId(1234);
        entity.setCategoryName("ABCD");
        entity.setAccount(account);

        //when
        AccountCategoryCreationDto dto = AccountCategoryMapper.INSTANCE.accountCategoryToAccountCategoryCreationDto(entity);

        //then
        assertEquals(dto.getId(), entity.getId());


    }

    @Test
    public void accountCategoryCreationDtoToAccountCategory() {
    }
}