package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
