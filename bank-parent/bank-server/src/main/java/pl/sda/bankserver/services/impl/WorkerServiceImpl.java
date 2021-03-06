package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.WorkerDto;
import pl.sda.bankserver.domain.Worker;
import pl.sda.bankserver.repository.WorkerRepository;
import pl.sda.bankserver.services.WorkerService;

import java.util.List;
import java.util.Map;

@Service
public class WorkerServiceImpl implements WorkerService {

    private WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public void createWorker(WorkerDto registrationDto) {

    }

    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public Worker findWorker(Map<String, String> customQuery) {
        return null;
    }

    @Override
    public void updateWorker(Map<String, String> customQuery, WorkerDto registrationDto) {

    }

    @Override
    public void deleteWorker(Map<String, String> customQuery) {

    }
}
