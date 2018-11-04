package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountDto;
import pl.sda.bankserver.domain.Account;

@Mapper
/**
 *
 * TODO polae accountCategoryId się nie mapuj
 *
 * */
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mappings({
            @Mapping(target = "accountCategoryId", source = "entity.accountCategory.id"),
            @Mapping(target = "services", source = "services"),
            @Mapping(target = "cards", source = "cards"),
            @Mapping(target = "accountHistories", source = "accountHistories")
    })
    AccountDto accountToAccountRegistrationDto(Account entity);

    @Mappings({
            @Mapping(target = "accountCategory.id", source = "dto.accountCategoryId"),
            @Mapping(target = "services", source = "services"),
            @Mapping(target = "cards", source = "cards"),
            @Mapping(target = "accountHistories", source = "accountHistories")
    })
    Account accountRegistrationDtoToAccount(AccountDto dto);

}
