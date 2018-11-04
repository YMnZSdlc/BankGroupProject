package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.WorkerDto;
import pl.sda.bankserver.domain.Worker;

import java.util.List;
import java.util.Map;

public interface WorkerService {
    void createWorker(WorkerDto registrationDto);

    List<Worker> findAll();

    Worker findWorker(Map<String, String> customQuery);

    void updateWorker(Map<String, String> customQuery, WorkerDto registrationDto);

    void deleteWorker(Map<String, String> customQuery);
}
