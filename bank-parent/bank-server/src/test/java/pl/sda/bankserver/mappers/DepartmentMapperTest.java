package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.DepartmentDto;
import pl.sda.bankserver.domain.Customer;
import pl.sda.bankserver.domain.Department;

import java.util.List;

import static org.junit.Assert.*;

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

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getDeptName(), dto.getDeptName());
        assertEquals(entity.getDeptNo(), dto.getDeptNo());
        assertEquals(entity.getPhoneNumber(), dto.getPhoneNumber());
        assertEquals(entity.getCustomers(), dto.getCustomers());
        assertEquals(entity.getWorkers(), dto.getWorkers());
        assertEquals(entity.getAddress().getId(), dto.getAddressId());

    }
}