package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.CardRegistrationDto;

@Controller
public class CardsController {

    @GetMapping("/cards")
    public String showCards(){
        return "accounts";
    }

    @GetMapping("/cards/save")
    public String viewFormToCreateCards(Model model) {
        model.addAttribute("save", new CardRegistrationDto());
        return "/cards/save";
    }

    @PostMapping("/cards/save")
    public String saveCards(@ModelAttribute CardRegistrationDto cardRegistrationDto) {
        return "cards/save";
    }

    @GetMapping("/cards/find")
    public String viewFormToFindCards(Model model) {
        model.addAttribute("find", new CardRegistrationDto());
        return "cards/find";
    }

    @PostMapping("/cards/find")
    public String findCards(@ModelAttribute CardRegistrationDto cardRegistrationDto) {
        return "cards/find";
    }

    @GetMapping("/cards/findall")
    public String findAllCardsByParam(Model model) {
        model.addAttribute("findall", new CardRegistrationDto());
        return "cards/find";
    }

    @PostMapping("/cards/findall")
    public String findAllCards(@ModelAttribute CardRegistrationDto cardRegistrationDto) {
        return "accounts/findall";
    }

    @GetMapping("/cards/update")
    public String chooseCardsForUpdate(Model model) {
        model.addAttribute("update", new CardRegistrationDto());
        return "cards/update";
    }

    @PutMapping("/cards/update")
    public String updateCards(@ModelAttribute CardRegistrationDto cardRegistrationDto) {
        return "cards/update";
    }

    @GetMapping("/cards/delete")
    public String findCardsToDelete(Model model) {
        model.addAttribute("delete", new CardRegistrationDto());
        return "cards/delete";
    }

    @DeleteMapping("/cards/delete")
    public String deleteCards(@ModelAttribute CardRegistrationDto cardRegistrationDto) {
        return "cards/delete";
    }
}
