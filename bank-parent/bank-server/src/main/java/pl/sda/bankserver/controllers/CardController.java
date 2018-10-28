package pl.sda.bankserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.CardRegistrationDto;
import pl.sda.bankserver.domain.Card;

import java.util.List;

@RestController
public class CardController {


    @PostMapping("/server/card/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestBody CardRegistrationDto registrationDto) {

    }

    @GetMapping("/server/card/all")
    public List<Card> findAll() {
        return null;
    }

    @GetMapping("/server/card/findbyid")
    public Card findCardById() {
        return null;
    }

}
