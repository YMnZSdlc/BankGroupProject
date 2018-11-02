package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
