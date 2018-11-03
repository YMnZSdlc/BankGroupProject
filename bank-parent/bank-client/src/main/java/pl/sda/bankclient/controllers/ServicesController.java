package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.ServiceDto;

@Controller
public class ServicesController {

    @GetMapping("/services")
    public String showServices() {
        return "services";
    }

    @GetMapping("/services/save")
    public String viewFormToCreateService(Model model) {
        model.addAttribute("save", new ServiceDto());
        return "services/save";
    }

    @PostMapping("/services/save")
    public String saveService(@ModelAttribute ServiceDto serviceDto) {
        return "services/save";
    }

    @GetMapping("/services/find")
    public String viewFormToFindService(Model model) {
        model.addAttribute("find", new ServiceDto());
        return "services/find";
    }

    @PostMapping("/services/find")
    public String findService(@ModelAttribute ServiceDto serviceDto) {
        return "services/find";
    }

    @GetMapping("/services/findall")
    public String findAllServicesByParam(Model model) {
        model.addAttribute("findall", new ServiceDto());
        return "services/findall";
    }

    @PostMapping("/services/findall")
    public String findAllServices(@ModelAttribute ServiceDto serviceDto) {
        return "services/findall";
    }

    @GetMapping("/services/update")
    public String chooseServiceForUpdate(Model model) {
        model.addAttribute("update", new ServiceDto());
        return "services/update";
    }

    @PutMapping("/services/update")
    public String updateService(@ModelAttribute ServiceDto serviceDto) {
        return "services/update";
    }

    @GetMapping("services/delete")
    public String findServiceToDelete(Model model) {
        model.addAttribute("delete", new ServiceDto());
        return "services/delete";
    }

    @DeleteMapping("services/delete")
    public String deleteService(@ModelAttribute ServiceDto serviceDto) {
        return "services/delete";
    }
}