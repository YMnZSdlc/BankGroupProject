package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;
import pl.sda.bankserver.domain.Account;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    //    @Mapping(source = , target = "")
    AccountRegistrationDto accountToAccountRegistrationDto(Account entity);

    Account accountRegistrationDtoToAccount(AccountRegistrationDto dto);

}
