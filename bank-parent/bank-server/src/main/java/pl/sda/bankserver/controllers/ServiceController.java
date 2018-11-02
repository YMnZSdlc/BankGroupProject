package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.ServiceCreationDto;
import pl.sda.bankserver.domain.Service;

import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {
    
//    private ServiceService serviceService;
//
//    @Autowired
//    public ServiceController(ServiceService serviceService) {
//        this.serviceService = serviceService;
//    }
    
    @PostMapping("/server/service/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createService(@RequestBody ServiceCreationDto creationDto) {
//        serviceService.createService(creationDto);
    }
    
    @GetMapping("/server/service/all")
    public List<Service> findAll() {
        return null;
    }
    
    @GetMapping("/server/service/find")
    public Service findService(@RequestParam Map<String, String> customQuery) {
        return null;
    }
    
    @PutMapping("/server/service/update")
    public void updateService(@RequestParam Map<String, String> customQuery, @RequestBody ServiceCreationDto creationDto) {
//        serviceService.updateService(customQuery, creationDto);
    }
    
    @DeleteMapping("/server/service/delete")
    public void deleteService(@RequestParam Map<String, String> customQuery) {
//        serviceService.deleteService(customQuery);
    }
}
