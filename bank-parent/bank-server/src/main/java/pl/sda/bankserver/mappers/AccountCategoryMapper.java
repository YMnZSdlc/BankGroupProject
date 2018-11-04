package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountCategoryDto;
import pl.sda.bankserver.domain.AccountCategory;

@Mapper
/**
* TODO pole accountId się nie mapuje
* */
public interface AccountCategoryMapper {

    AccountCategoryMapper INSTANCE = Mappers.getMapper(AccountCategoryMapper.class);

    @Mapping(target = "accountId", source = "entity.account.id")
    AccountCategoryDto accountCategoryToAccountCategoryDto(AccountCategory entity);

    @Mapping(target = "account.id", source = "dto.accountId")
    AccountCategory accountCategoryDtoToAccountCategory(AccountCategoryDto dto);

}
