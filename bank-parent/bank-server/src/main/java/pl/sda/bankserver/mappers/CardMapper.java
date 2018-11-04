package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.CardDto;
import pl.sda.bankserver.domain.Card;

@Mapper
/**TODO
 *
 * pola accountId się nie mapują
 *
 * */
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    @Mapping(target = "accountId", source = "entity.account.id")
    CardDto cardToCardDto(Card entity);

    @Mapping(target = "account.id", source = "dto.accountId")
    Card cardDtoToCard(CardDto dto);

}
