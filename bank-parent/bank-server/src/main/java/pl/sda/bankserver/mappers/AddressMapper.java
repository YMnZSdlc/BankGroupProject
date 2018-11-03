package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AddressDto;
import pl.sda.bankserver.domain.Address;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto addressToAddressDto(Address entity);

    Address addressDtoToAddress(AddressDto dto);

}
