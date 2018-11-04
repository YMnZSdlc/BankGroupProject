package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.CardRegistrationDto;
import pl.sda.bankserver.domain.Card;
import pl.sda.bankserver.repository.CardRepository;
import pl.sda.bankserver.services.CardService;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.time.LocalDate.parse;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void createCard(CardRegistrationDto registrationDto) {
        Card card = Card.builder()
                .cardType(registrationDto.getCardType())
                .cardNo(registrationDto.getCardNo())
                .cvcCvvCode(registrationDto.getCvcCvvCode())
                .activationDate(registrationDto.getActivationDate())
                .expireDate(registrationDto.getExpireDate())
                .build();
        cardRepository.saveAndFlush(card);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public List<Card> findCard(Map<String, String> customQuery) {
        String cardType = customQuery.get("cardType");
        String cardNo = customQuery.get("cardNo");
        String cvcCvvCode = customQuery.get("cvcCvvCode");
        String activationDate = customQuery.get("activationDate");
        String expireDate = customQuery.get("expireDate");
        return cardRepository.findByCardTypeOrCardNoOrCvcCvvCodeOrActivationDateOrExpireDate(
                cardType,
                cardNo,
                parseInt(cvcCvvCode),
                parse(activationDate),
                parse(expireDate));
    }

    @Override
    public void updateCard(Map<String, String> customQuery, CardRegistrationDto registrationDto) {
        Card card = findCard(customQuery).get(0);
        card = Card.builder()
                .id(card.getId())
                .cardType(registrationDto.getCardType())
                .cardNo(registrationDto.getCardNo())
                .cvcCvvCode(registrationDto.getCvcCvvCode())
                .activationDate(registrationDto.getActivationDate())
                .expireDate(registrationDto.getExpireDate())
                .build();
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Map<String, String> customQuery) {
        Card card = findCard(customQuery).get(0);
        cardRepository.delete(card);
    }
}
