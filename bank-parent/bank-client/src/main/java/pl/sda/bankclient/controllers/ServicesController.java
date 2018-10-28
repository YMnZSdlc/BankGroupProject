package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.ServiceCreationDto;

@Controller
public class ServicesController {


    @GetMapping("/services")
    public String showService() {

        return "services";
    }


    @GetMapping("/services/save")
    public String viewFormToCreateService(Model model) {

        model.addAttribute("save", new ServiceCreationDto());

        return "services/save";
    }

    @PostMapping("/services/save")
    public String saveService(@ModelAttribute ServiceCreationDto serviceCreationDto) {

        return "services/save";
    }

    @GetMapping("/services/find")
    public String viewFormToFindService(Model model) {

        model.addAttribute("find", new ServiceCreationDto());

        return "services/find";
    }

    @PostMapping("/services/find")
    public String findService(@ModelAttribute ServiceCreationDto serviceCreationDto) {


        return "services/find";
    }


    @GetMapping("/services/findall")
    public String findAllServicesByParam(Model model) {

        model.addAttribute("findall", new ServiceCreationDto());

        return "services/findall";
    }

    @PostMapping("/services/findall")
    public String findallService(@ModelAttribute ServiceCreationDto serviceCreationDto) {


        return "services/findall";
    }


    @GetMapping("/services/update")
    public String chooseServiceForUpdate(Model model) {

        model.addAttribute("update", new ServiceCreationDto());

        return "services/update";
    }

    @PutMapping("/services/update")
    public String updateService(@ModelAttribute ServiceCreationDto serviceCreationDto) {
        return "services/update";
    }


    @GetMapping("services/delete")
    public String findServiceToDelete(Model model) {

        model.addAttribute("delete", new ServiceCreationDto());

        return "services/delete";
    }

    @DeleteMapping("services/delete")
    public String deleteService(@ModelAttribute ServiceCreationDto serviceCreationDto) {
        return "services/delete";
    }

}