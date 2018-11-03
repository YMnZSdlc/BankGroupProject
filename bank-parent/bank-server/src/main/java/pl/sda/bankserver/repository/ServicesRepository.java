package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Service;

public interface ServicesRepository extends JpaRepository<Service, Integer> {

}
