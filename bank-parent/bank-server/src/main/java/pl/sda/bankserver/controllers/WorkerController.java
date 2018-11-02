package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.WorkerRegistrationDto;
import pl.sda.bankserver.domain.Worker;
import pl.sda.bankserver.services.WorkerService;

import java.util.List;
import java.util.Map;

@RestController
public class WorkerController {
    
    private WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }
    
    @PostMapping("/server/worker/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorker(@RequestBody WorkerRegistrationDto registrationDto) {
//        workerService.createWorker(registrationDto);
    }
    
    @GetMapping("/server/worker/all")
    public List<Worker> findAll() {
        return null;
    }
    
    @GetMapping("/server/worker/find")
    public Worker findWorker(@RequestParam Map<String, String> customQuery) {
        return null;
    }
    
    @PutMapping("/server/worker/update")
    public void updateWorker(@RequestParam Map<String, String> customQuery, @RequestBody WorkerRegistrationDto registrationDto) {
//        workerService.updateWorker(customQuery, registrationDto);
    }
    
    @DeleteMapping("/server/worker/delete")
    public void deleteWorker(@RequestParam Map<String, String> customQuery) {
//        workerService.deleteWorker(customQuery);
    }
}
