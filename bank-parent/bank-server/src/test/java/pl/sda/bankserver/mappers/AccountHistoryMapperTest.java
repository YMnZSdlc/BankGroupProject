package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AccountHistoryDto;
import pl.sda.bankserver.domain.AccountHistory;

import static org.junit.Assert.*;

public class AccountHistoryMapperTest {

    @Test
    public void accountHistoryToAccountHistoryDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        AccountHistory entityIn = fakeDomains.getAccountHistory();

        //when
        AccountHistoryDto dtoOut = AccountHistoryMapper.INSTANCE.accountHistoryToAccountHistoryDto(entityIn);

        //then
        assertEquals(dtoOut.getId(),            entityIn.getId());

    }

    @Test
    public void accountHistoryDtoToAccountHistory() {
    }
}