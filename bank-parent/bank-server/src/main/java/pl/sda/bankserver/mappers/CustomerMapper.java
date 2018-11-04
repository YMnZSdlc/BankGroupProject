package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.CustomerDto;
import pl.sda.bankserver.domain.Customer;
import pl.sda.bankserver.domain.Department;

@Mapper
/**
 *
 * TODO pola departmentId, addressId się nie mapują
 *
 * */
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "departmentId", source = "entity.department.id"),
            @Mapping(target = "addressId", source = "entity.address.id"),
            @Mapping(target = "accounts", source = "accounts")
    })
    CustomerDto customerToCustomerDto(Customer entity);

    @Mappings({
            @Mapping(target = "department.id", source = "dto.departmentId"),
            @Mapping(target = "address.id", source = "dto.addressId"),
            @Mapping(target = "accounts", source = "accounts")
    })
    Customer customerDtoToCustomer(CustomerDto dto);

    @Mapping(target = "id", source = "departmentId")
    Department departmentIdToDepartment(Integer departmentId);
}