package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.CustomerDto;
import pl.sda.bankserver.domain.Customer;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    @Test
    public void customerToCustomerDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        Customer entityIn = fakeDomains.getCustomer();

        //when
        CustomerDto dtoOut = CustomerMapper.INSTANCE.customerToCustomerDto(entityIn);

        //then
        assertEquals(dtoOut.getId(),    entityIn.getId());

    }

    @Test
    public void customerDtoToCustomer() {
        //given
        CustomerDto dto = FakeDtos.createCustomerDto();

        //when
        Customer entity = CustomerMapper.INSTANCE.customerDtoToCustomer(dto);

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getPassword(), dto.getPassword());
        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getPesel(), dto.getPesel());
        assertEquals(entity.getCreateDate(), dto.getCreateDate());
        assertEquals(entity.getEmail(), dto.getEmail());
        assertEquals(entity.getPhoneNumber(), dto.getPhoneNumber());
        assertEquals(entity.getDateOfBirth(), dto.getDateOfBirth());
        assertEquals(entity.getSex(), dto.getSex());
//        assertEquals(entity.getAccounts(), dto.getAccounts());
        assertEquals(entity.getAccounts().get(0).getAccountHistories(), dto.getAccounts().get(0).getAccountHistories());
        assertEquals(entity.getDepartment().getId(), dto.getDepartmentId());
        assertEquals(entity.getAddress().getId(), dto.getAddressId());
    }
}