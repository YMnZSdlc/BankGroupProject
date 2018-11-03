package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.ServiceDto;
import pl.sda.bankserver.domain.Service;

@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "addressId", source = "entity.address.id")
    ServiceDto serviceToServiceCreationDto(Service entity);

    @Mapping(target = "address.id", source = "dto.addressId")
    Service serviceCreationDtoToService(ServiceDto dto);
}
