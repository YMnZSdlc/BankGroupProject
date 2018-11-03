package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    //    @Mapping(source = , target = "")
    AccountDto accountToAccountRegistrationDto(Account entity);

    Account accountRegistrationDtoToAccount(AccountDto dto);

}
