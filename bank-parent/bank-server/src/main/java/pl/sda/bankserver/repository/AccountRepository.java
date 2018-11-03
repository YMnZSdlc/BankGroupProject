package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
List<Account>findAll();
List<Account>findAllByNumber(String number);

}
