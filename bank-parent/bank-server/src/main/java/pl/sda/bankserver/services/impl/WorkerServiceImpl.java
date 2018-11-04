package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.WorkerRegistrationDto;
import pl.sda.bankserver.domain.Worker;
import pl.sda.bankserver.services.WorkerService;

import java.util.List;
import java.util.Map;

@Service
public class WorkerServiceImpl implements WorkerService {
    
    private WorkerService workerService;
    
    @Autowired
        public WorkerServiceImpl(WorkerService workerService) {
        this.workerService = workerService;
    }
    
    @Override
    public void createWorker(WorkerRegistrationDto registrationDto) {
    
    }
    
    @Override
    public List<Worker> findAll() {
        return null;
    }
    
    @Override
    public List<Worker> findWorker(Map<String, String> customQuery) {
        return null;
    }
    
    @Override
    public void updateWorker(Map<String, String> customQuery, WorkerRegistrationDto registrationDto) {
    
    }
    
    @Override
    public void deleteWorker(Map<String, String> customQuery) {
    
    }
}
