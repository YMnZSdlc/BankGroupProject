package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.CardRegistrationDto;
import pl.sda.bankserver.domain.Card;

import java.util.List;
import java.util.Map;

public interface CardService {
    void createCard(CardRegistrationDto registrationDto);
    
    List<Card> findAll();
    
    List<Card> findCard(Map<String, String> customQuery);
    
    void updateCard(Map<String, String> customQuery, CardRegistrationDto registrationDto);
    
    void deleteCard(Map<String, String> customQuery);
}
