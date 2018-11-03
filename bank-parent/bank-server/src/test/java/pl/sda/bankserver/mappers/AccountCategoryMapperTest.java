package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountCategoryDto;
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
        AccountCategoryDto dto = AccountCategoryMapper.INSTANCE.accountCategoryToAccountCategoryDto(entity);

        //then
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getCategoryName(), entity.getCategoryName());
        assertEquals(dto.getAccountId(), entity.getAccount().getId());
    }

    @Test
    public void accountCategoryCreationDtoToAccountCategory() {
        //given
        AccountCategoryDto dto = new AccountCategoryDto();
        dto.setId(5678);
        dto.setCategoryName("EFGH");
        dto.setAccountId(1234);

        //when
        AccountCategory entity = AccountCategoryMapper.INSTANCE.accountCategoryDtoToAccountCategory(dto);

        //then
        assertEquals(entity.getId(),dto.getId());
        assertEquals(entity.getCategoryName(),dto.getCategoryName());
        assertEquals(entity.getAccount().getId(),dto.getAccountId());
    }
}