package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.CardDto;
import pl.sda.bankserver.domain.Card;

import static org.junit.Assert.*;

public class CardMapperTest {

    @Test
    public void cardToCardDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        Card entityIn = fakeDomains.getCard();

        //when
        CardDto dtoOut = CardMapper.INSTANCE.cardToCardDto(entityIn);

        //then
        assertEquals(dtoOut.getId(), entityIn.getId());
    }

    @Test
    public void cardDtoToCard() {
        CardDto dto = FakeDtos.createCardDto();

        //when
        Card entity = CardMapper.INSTANCE.cardDtoToCard(dto);

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getCardType(), dto.getCardType());
        assertEquals(entity.getCardNo(), dto.getCardNo());
        assertEquals(entity.getCvcCvvCode(), dto.getCvcCvvCode());
        assertEquals(entity.getActivationDate(), dto.getActivationDate());
        assertEquals(entity.getExpireDate(), dto.getExpireDate());
        assertEquals(entity.getAccount().getId(), dto.getAccountId());
    }
}