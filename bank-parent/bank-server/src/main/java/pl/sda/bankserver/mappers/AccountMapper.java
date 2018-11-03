package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "accountCategoryId", source = "entity.accountCategory.id")
    AccountDto accountToAccountRegistrationDto(Account entity);

    @Mapping(target = "accountCategory.id", source = "dto.accountCategoryId")
    Account accountRegistrationDtoToAccount(AccountDto dto);

}
