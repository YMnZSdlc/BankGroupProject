package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.ServiceDto;
import pl.sda.bankserver.domain.Service;

import static org.junit.Assert.*;

public class ServiceMapperTest {

    @Test
    public void serviceToServiceDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        Service entityIn = fakeDomains.getService();

        //when
        ServiceDto dtoOut = ServiceMapper.INSTANCE.serviceToServiceDto(entityIn);

        //then
        assertEquals(dtoOut.getId(),    entityIn.getId());
    }

    @Test
    public void serviceDtoToService() {
        //given
        ServiceDto dto = FakeDtos.createServiceDto();

        //when
        Service entity = ServiceMapper.INSTANCE.serviceDtoToService(dto);

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getService(), dto.getService());
        assertEquals(entity.getNumber(), dto.getNumber());
        assertEquals(entity.getTitle(), dto.getTitle());
        assertEquals(entity.getDate(), dto.getDate());
        assertEquals(entity.getAmount(), dto.getAmount());
        assertEquals(entity.getCurrency(), dto.getCurrency());
        assertEquals(entity.getStartTime(), dto.getStartTime());
        assertEquals(entity.getEndTime(), dto.getEndTime());
        assertEquals(entity.getSenderAccount(), dto.getSenderAccount());
        assertEquals(entity.getRecipientAccount(), dto.getRecipientAccount());
        assertEquals(entity.getAccount().getId(), dto.getAccountId());
    }
}