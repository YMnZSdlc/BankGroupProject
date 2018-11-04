package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.AddressDto;
import pl.sda.bankserver.domain.Address;

import static org.junit.Assert.*;

public class AddressMapperTest {



    @Test
    public void addressToAddressDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        Address entityIn = fakeDomains.getAddress();

        //when
        AddressDto dtoOut = AddressMapper.INSTANCE.addressToAddressDto(entityIn);

        //then
        assertEquals(dtoOut.getId(),    entityIn.getId());

    }

    @Test
    public void addressDtoToAddress() {
        //given
        AddressDto dto = FakeDtos.createAddressDto();

        //when
        Address entity = AddressMapper.INSTANCE.addressDtoToAddress(dto);

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getStreetName(), dto.getStreetName());
        assertEquals(entity.getStreetNo(), dto.getStreetNo());
        assertEquals(entity.getHomeNo(), dto.getHomeNo());
        assertEquals(entity.getCity(), dto.getCity());
        assertEquals(entity.getZipCode(), dto.getZipCode());
        assertEquals(entity.getCustomersAddresses().get(0).getId(), dto.getCustomersAddresses().get(0).getId());
        assertEquals(entity.getCustomersAddresses().get(0).getFirstName(), dto.getCustomersAddresses().get(0).getFirstName());
        assertEquals(entity.getWorkerAddresses().get(0).getPhoneNumber(), dto.getWorkerAddresses().get(0).getPhoneNumber());
        assertEquals(entity.getWorkerAddresses().get(0).getPassword(), dto.getWorkerAddresses().get(0).getPassword());
    }
}