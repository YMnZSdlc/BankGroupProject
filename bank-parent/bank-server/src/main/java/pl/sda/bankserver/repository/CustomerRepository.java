package pl.sda.bankserver.repository;

import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Customer;

public interface CustomerRepository extends Repository<Customer, Integer> {

}
