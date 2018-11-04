package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.ServiceCreationDto;
import pl.sda.bankserver.repository.ServicesRepository;
import pl.sda.bankserver.services.ServiceService;

import java.util.List;
import java.util.Map;

@Service
public class ServiceServiceImpl implements ServiceService {
    
    private ServicesRepository servicesRepository;
    
    @Autowired
    public ServiceServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }
    
    @Override
    public void createService(ServiceCreationDto creationDto) {
    
    }
    
    @Override
    public List<pl.sda.bankserver.domain.Service> findAll() {
        return null;
    }
    
    @Override
    public List<pl.sda.bankserver.domain.Service> findService(Map<String, String> customQuery) {
        return null;
    }
    
    @Override
    public void updateService(Map<String, String> customQuery, ServiceCreationDto creationDto) {
    
    }
    
    @Override
    public void deleteService(Map<String, String> customQuery) {
    
    }
}
