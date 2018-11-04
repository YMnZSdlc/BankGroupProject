package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.ServiceDto;
import pl.sda.bankserver.domain.Service;

import java.util.List;
import java.util.Map;

public interface ServiceService {
    void createService(ServiceDto creationDto);

    List<Service> findAll();

    Service findService(Map<String, String> customQuery);

    void updateService(Map<String, String> customQuery, ServiceDto creationDto);

    void deleteService(Map<String, String> customQuery);
}
