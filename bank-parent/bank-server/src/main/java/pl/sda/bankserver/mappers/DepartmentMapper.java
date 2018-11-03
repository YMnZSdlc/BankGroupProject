package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.DepartmentDto;
import pl.sda.bankserver.domain.Department;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(target = "addressId", source = "entity.address.id")
    DepartmentDto departmentToDepartmentDto(Department entity);

    @Mapping(target = "address.id", source = "dto.addressId")
    Department departmentDtoToDepartment(DepartmentDto dto);
}
