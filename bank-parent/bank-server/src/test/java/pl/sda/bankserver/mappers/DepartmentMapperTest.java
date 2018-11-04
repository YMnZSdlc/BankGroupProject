package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.DepartmentDto;
import pl.sda.bankserver.domain.Customer;
import pl.sda.bankserver.domain.Department;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepartmentMapperTest {

    @Test
    public void departmentToDepartmentDto() {
    }

    @Test
    public void departmentDtoToDepartment() {
        //given
        DepartmentDto dto = FakeDtos.createDepartmentDto();

        //when
        Department entity = DepartmentMapper.INSTANCE.departmentDtoToDepartment(dto);
        Customer customer = dto.getCustomers().stream().map(CustomerMapper.INSTANCE::customerDtoToCustomer).findFirst().orElseThrow(RuntimeException::new);
        List<Customer> customerList = new ArrayList();
        customerList.add(customer);
        entity.setCustomers(customerList);
        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getDeptName(), dto.getDeptName());
        assertEquals(entity.getDeptNo(), dto.getDeptNo());
        assertEquals(entity.getPhoneNumber(), dto.getPhoneNumber());
        assertEquals(entity.getCustomers().get(0).getId(), dto.getCustomers().get(0).getId());
        assertEquals(entity.getWorkers().get(0).getId(), dto.getWorkers().get(0).getId());
        assertEquals(entity.getAddress().getId(), dto.getAddressId()); //FAIL

    }
}