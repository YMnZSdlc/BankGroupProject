package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/start")
    public String showIndex(){
        return "index";
    }
}
