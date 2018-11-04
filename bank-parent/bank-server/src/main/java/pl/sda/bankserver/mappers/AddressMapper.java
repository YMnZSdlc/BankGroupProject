package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AddressDto;
import pl.sda.bankserver.domain.Address;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({
            @Mapping(target = "customersAddresses", source = "customersAddresses"),
            @Mapping(target = "workerAddresses", source = "workerAddresses"),
            @Mapping(target = "departmentsAddresses", source = "departmentsAddresses")
    })
    AddressDto addressToAddressDto(Address entity);

    @Mappings({
            @Mapping(target = "customersAddresses", source = "customersAddresses"),
            @Mapping(target = "workerAddresses", source = "workerAddresses"),
            @Mapping(target = "departmentsAddresses", source = "departmentsAddresses")
    })
    Address addressDtoToAddress(AddressDto dto);

}
