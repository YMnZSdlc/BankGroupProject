package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountRegistrationDto;
import pl.sda.bankserver.domain.Account;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mappings({
            @Mapping(target="serviceIds", source="entity.services"),
            @Mapping(target="cardIds", source="entity.cards"),
            @Mapping(target="accountCategoryId", source="entity.accountCategory"),
            @Mapping(target="accountHistoryIds", source="entity.accountHistories"),
            @Mapping(target="customerIds", source="entity.accountHistories")
    })
    AccountRegistrationDto accountToAccountRegistrationDto (Account entity);

    @Mappings({
            @Mapping(target="services", source="dto.serviceIds"),
            @Mapping(target="cards", source="dto.cardIds"),
            @Mapping(target="accountCategory", source="dto.accountCategoryId"),
            @Mapping(target="accountHistories", source="dto.accountHistoryIds"),
            @Mapping(target="accountHistories", source="dto.customerIds")
    })
    Account accountRegistrationDtoToAccount (AccountRegistrationDto dto);


}
