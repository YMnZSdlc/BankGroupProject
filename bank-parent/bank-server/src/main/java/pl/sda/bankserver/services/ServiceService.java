package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.ServiceCreationDto;
import pl.sda.bankserver.domain.Service;

import java.util.List;
import java.util.Map;

public interface ServiceService {
    void createService(ServiceCreationDto creationDto);

    List<Service> findAll();

    Service findService(Map<String, String> customQuery);

    void updateService(Map<String, String> customQuery, ServiceCreationDto creationDto);

    void deleteService(Map<String, String> customQuery);
}
