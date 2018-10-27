package pl.sda.bankclient;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/start")
    public String showIndex(Model model){
        model.addAttribute("startPage","Sztos");
        return "index";
    }
}
