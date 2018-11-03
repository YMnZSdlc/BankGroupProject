package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.CardRegistrationDto;
import pl.sda.bankserver.domain.Card;
import pl.sda.bankserver.services.CardService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class CardController {
    
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    
    @PostMapping("/server/card/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestBody @Valid CardRegistrationDto registrationDto) {
//        cardService.createCard(registrationDto);
    }
    
    @GetMapping("/server/card/all")
    public List<Card> findAll() {
        return cardService.findAll();
    }
    
    @GetMapping("/server/card/find")
    public List<Card> findCard(@RequestParam Map<String, String> customQuery) {
        return cardService.findCard(customQuery);
    }
    
    @PutMapping("/server/card/update")
    public void updateCard(@RequestParam Map<String, String> customQuery, @RequestBody @Valid CardRegistrationDto registrationDto) {
//        cardService.updateCard(customQuery, registrationDto);
    }
    
    @DeleteMapping("/server/card/delete")
    public void deleteCard(@RequestParam Map<String, String> customQuery) {
//        cardService.deleteCard(customQuery);
    }
}
