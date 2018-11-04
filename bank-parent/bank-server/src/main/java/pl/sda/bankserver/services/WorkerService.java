package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.WorkerRegistrationDto;
import pl.sda.bankserver.domain.Worker;

import java.util.List;
import java.util.Map;

public interface WorkerService {
    void createWorker(WorkerRegistrationDto registrationDto);
    
    List<Worker> findAll();
    
    List<Worker> findWorker(Map<String, String> customQuery);
    
    void updateWorker(Map<String, String> customQuery, WorkerRegistrationDto registrationDto);
    
    void deleteWorker(Map<String, String> customQuery);
}
