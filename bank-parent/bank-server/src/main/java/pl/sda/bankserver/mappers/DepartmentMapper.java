package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.DepartmentDto;
import pl.sda.bankserver.domain.Address;
import pl.sda.bankserver.domain.Department;

@Mapper
/**
 *
 * TODO pola addressId się nie mapują
 *
 * */
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mappings({
            @Mapping(target = "addressId", source = "entity.address.id"),
            @Mapping(target = "customers", source = "customers"),
            @Mapping(target = "workers", source = "workers")
    })
    DepartmentDto departmentToDepartmentDto(Department entity);

    @Mappings({
            @Mapping(target = "address.id", source = "dto.addressId"),
            @Mapping(target = "customers", source = "customers"),
            @Mapping(target = "workers", source = "workers")
    })
    Department departmentDtoToDepartment(DepartmentDto dto);

    @Mapping(target = "id", source = "addressId")
    Address addressIdToAddress(Integer addressId);

    @Mapping(target = "id", source = "departmentId")
    Department departmnetIdToDepartment(Integer departmentId);

}
