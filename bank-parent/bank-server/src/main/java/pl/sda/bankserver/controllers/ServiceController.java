package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.ServiceDto;
import pl.sda.bankserver.domain.Service;
import pl.sda.bankserver.services.ServiceService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {
    
    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
    
    @PostMapping("/server/service/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createService(@RequestBody @Valid ServiceDto creationDto) {
//        serviceService.createService(creationDto);
    }
    
    @GetMapping("/server/service/all")
    public List<Service> findAll() {
        return serviceService.findAll();
    }
    
    @GetMapping("/server/service/find")
    public Service findService(@RequestParam Map<String, String> customQuery) {
        return serviceService.findService(customQuery);
    }
    
    @PutMapping("/server/service/update")
    public void updateService(@RequestParam Map<String, String> customQuery, @RequestBody @Valid ServiceDto creationDto) {
        serviceService.updateService(customQuery, creationDto);
    }
    
    @DeleteMapping("/server/service/delete")
    public void deleteService(@RequestParam Map<String, String> customQuery) {
        serviceService.deleteService(customQuery);
    }
}
