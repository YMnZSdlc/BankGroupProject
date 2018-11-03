package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.CardDto;

@Controller
public class CardsController {

    @GetMapping("/cards")
    public String showCards(){
        return "cards";
    }

    @GetMapping("/cards/save")
    public String viewFormToCreateCard(Model model) {
        model.addAttribute("save", new CardDto());
        return "/cards/save";
    }

    @PostMapping("/cards/save")
    public String saveCard(@ModelAttribute CardDto cardDto) {
        return "cards/save";
    }

    @GetMapping("/cards/find")
    public String viewFormToFindCard(Model model) {
        model.addAttribute("find", new CardDto());
        return "cards/find";
    }

    @PostMapping("/cards/find")
    public String findCard(@ModelAttribute CardDto cardDto) {
        return "cards/find";
    }

    @GetMapping("/cards/findall")
    public String findAllCardsByParam(Model model) {
        model.addAttribute("findall", new CardDto());
        return "cards/findall";
    }

    @PostMapping("/cards/findall")
    public String findAllCards(@ModelAttribute CardDto cardDto) {
        return "cards/findall";
    }

    @GetMapping("/cards/update")
    public String chooseCardForUpdate(Model model) {
        model.addAttribute("update", new CardDto());
        return "cards/update";
    }

    @PutMapping("/cards/update")
    public String updateCard(@ModelAttribute CardDto cardDto) {
        return "cards/update";
    }

    @GetMapping("/cards/delete")
    public String findCardToDelete(Model model) {
        model.addAttribute("delete", new CardDto());
        return "cards/delete";
    }

    @DeleteMapping("/cards/delete")
    public String deleteCard(@ModelAttribute CardDto cardDto) {
        return "cards/delete";
    }
}
