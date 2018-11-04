package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountCategoryDto;
import pl.sda.bankserver.domain.AccountCategory;

import static org.junit.Assert.assertEquals;

public class AccountCategoryMapperTest {

    @Test
    public void accountCategoryToAccountCategoryDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        AccountCategory entityIn = fakeDomains.getAccountCategory();

        //when
        AccountCategoryDto dtoOut = AccountCategoryMapper.INSTANCE.accountCategoryToAccountCategoryDto(entityIn);

        //then
        assertEquals(dtoOut.getId(), entityIn.getId());
        assertEquals(dtoOut.getCategoryName(), entityIn.getCategoryName());
        assertEquals(dtoOut.getAccountId(), entityIn.getAccount().getId());
    }

    @Test
    public void accountCategoryDtoToAccountCategory() {
        //given
        AccountCategoryDto dto = new AccountCategoryDto();
        dto.setId(5678);
        dto.setCategoryName("EFGH");
        dto.setAccountId(1234);

        //when
        AccountCategory entity = AccountCategoryMapper.INSTANCE.accountCategoryDtoToAccountCategory(dto);

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getCategoryName(), dto.getCategoryName());
        assertEquals(entity.getAccount().getId(), dto.getAccountId());
    }
}