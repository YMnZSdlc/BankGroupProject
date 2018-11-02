package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.CardRegistrationDto;
import pl.sda.bankserver.domain.Card;
import pl.sda.bankserver.services.CardService;

import java.util.List;
import java.util.Map;

@Service
public class CardServiceImpl implements CardService {
    
    private CardService cardService;
    
    @Autowired
    public CardServiceImpl(CardService cardService) {
        this.cardService = cardService;
    }
    
    @Override
    public void createCard(CardRegistrationDto registrationDto) {
    
    }
    
    @Override
    public List<Card> findAll() {
        return null;
    }
    
    @Override
    public List<Card> findCard(Map<String, String> customQuery) {
        return null;
    }
    
    @Override
    public void updateCard(Map<String, String> customQuery, CardRegistrationDto registrationDto) {
    
    }
    
    @Override
    public void deleteCard(Map<String, String> customQuery) {
    
    }
}
