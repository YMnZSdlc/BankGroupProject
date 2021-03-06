package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.ServiceDto;
import pl.sda.bankserver.domain.Service;

@Mapper
/**
 *
 * TODO pole accountId się nie mapuje
 *
 * */
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "accountId", source = "entity.account.id")
    ServiceDto serviceToServiceDto(Service entity);

    @Mapping(target = "account.id", source = "dto.accountId")
    Service serviceDtoToService(ServiceDto dto);
}
