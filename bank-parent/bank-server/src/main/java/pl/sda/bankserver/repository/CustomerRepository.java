package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
