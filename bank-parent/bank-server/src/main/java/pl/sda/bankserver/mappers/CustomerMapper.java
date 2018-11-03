package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.CustomerDto;
import pl.sda.bankserver.domain.Customer;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "departmentId", source = "entity.department.id"),
            @Mapping(target = "addressId", source = "entity.address.id")
    })
    CustomerDto customerToCustomerDto(Customer entity);

    @Mappings({
            @Mapping(target = "department.id", source = "dto.departmentId"),
            @Mapping(target = "address.id", source = "dto.addressId")
    })
    Customer customerDtoToCustomer(CustomerDto dto);
}