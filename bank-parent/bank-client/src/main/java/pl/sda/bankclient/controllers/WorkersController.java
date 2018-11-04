package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.WorkerDto;

@Controller
public class WorkersController {

    @GetMapping("/workers")
    public String showWorkers() {
        return "workers";
    }

    @GetMapping("/workers/save")
    public String viewFormToCreateWorker(Model model) {
        model.addAttribute("save", new WorkerDto());
        return "workers/save";
    }

    @PostMapping("/workers/save")
    public String saveWorker(@ModelAttribute WorkerDto workerDto) {
        return "workers/save";
    }

    @GetMapping("/workers/find")
    public String viewFormToFindWorker(Model model) {
        model.addAttribute("find", new WorkerDto());
        return "workers/find";
    }

    @PostMapping("/workers/find")
    public String findWorker(@ModelAttribute WorkerDto workerDto) {
        return "workers/find";
    }

    @GetMapping("/workers/findall")
    public String findAllWorkersByParam(Model model) {
        model.addAttribute("findall", new WorkerDto());
        return "workers/findall";
    }

    @PostMapping("/workers/findall")
    public String findAllWorkers(@ModelAttribute WorkerDto workerDto) {
        return "workers/findall";
    }

    @GetMapping("/workers/update")
    public String chooseWorkerForUpdate(Model model) {
        model.addAttribute("update", new WorkerDto());
        return "workers/update";
    }

    @PutMapping("/workers/update")
    public String updateWorker(@ModelAttribute WorkerDto workerDto) {
        return "workers/update";
    }

    @GetMapping("workers/delete")
    public String findWorkerToDelete(Model model) {
        model.addAttribute("delete", new WorkerDto());
        return "workers/delete";
    }

    @DeleteMapping("workers/delete")
    public String deleteWorker(@ModelAttribute WorkerDto workerDto) {
        return "workers/delete";
    }

}
