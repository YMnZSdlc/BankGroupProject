package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.WorkerRegistrationDto;

@Controller
public class WorkersController {

    @GetMapping("/workers")
    public String showworkers() {

        return "workers";
    }


    @GetMapping("/workers/save")
    public String viewFormToCreateWorker(Model model) {

        model.addAttribute("save", new WorkerRegistrationDto());

        return "workers/save";
    }

    @PostMapping("/workers/save")
    public String saveWorker(@ModelAttribute WorkerRegistrationDto WorkerRegistrationDto) {

        return "workers/save";
    }

    @GetMapping("/workers/find")
    public String viewFormToFindWorker(Model model) {

        model.addAttribute("find", new WorkerRegistrationDto());

        return "workers/find";
    }

    @PostMapping("/workers/find")
    public String findWorker(@ModelAttribute WorkerRegistrationDto WorkerRegistrationDto) {


        return "workers/find";
    }


    @GetMapping("/workers/findall")
    public String findAllworkersByParam(Model model) {

        model.addAttribute("findall", new WorkerRegistrationDto());

        return "workers/findall";
    }

    @PostMapping("/workers/findall")
    public String findallworkers(@ModelAttribute WorkerRegistrationDto WorkerRegistrationDto) {


        return "workers/findall";
    }


    @GetMapping("/workers/update")
    public String chooseWorkerForUpdate(Model model) {

        model.addAttribute("update", new WorkerRegistrationDto());

        return "workers/update";
    }

    @PutMapping("/workers/update")
    public String updateWorker(@ModelAttribute WorkerRegistrationDto WorkerRegistrationDto) {
        return "workers/update";
    }


    @GetMapping("workers/delete")
    public String findWorkerToDelete(Model model) {

        model.addAttribute("delete", new WorkerRegistrationDto());

        return "workers/delete";
    }

    @DeleteMapping("workers/delete")
    public String deleteWorker(@ModelAttribute WorkerRegistrationDto WorkerRegistrationDto) {
        return "workers/delete";
    }

}
