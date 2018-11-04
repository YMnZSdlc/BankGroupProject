package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.AccountHistoryDto;
import pl.sda.bankserver.domain.AccountHistory;

@Mapper
/**TODO
 * pola się nie mapują
 * */
public interface AccountHistoryMapper {

    AccountHistoryMapper INSTANCE = Mappers.getMapper(AccountHistoryMapper.class);

    @Mapping(target = "accountId", source = "entity.account.id")
    AccountHistoryDto accountHistoryToAccountHistoryDto(AccountHistory entity);

    @Mapping(target = "account.id", source = "dto.accountId")
    AccountHistory accountHistoryDtoToAccountHistory(AccountHistoryDto dto);

}
