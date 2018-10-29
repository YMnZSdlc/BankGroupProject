package pl.sda.bankserver.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountCategoryCreationDto;
import pl.sda.bankserver.domain.AccountCategory;

@Mapper
public interface AccountCategoryMapper {

    AccountCategoryMapper INSTANCE = Mappers.getMapper(AccountCategoryMapper.class);

//    AccountCategory accountCategoryCreationDtoToAccountCategory (AccountCategoryCreationDto accountCategoryCreationDto);

//    AccountCategoryCreationDto accountCategoryToAccountCategoryCreationDto (AccountCategory accountCategory);

    // TODO: 28.10.2018

}
