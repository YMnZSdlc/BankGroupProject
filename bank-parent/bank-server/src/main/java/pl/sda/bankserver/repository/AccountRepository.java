package pl.sda.bankserver.repository;

import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Account;

public interface AccountRepository extends Repository<Account, Integer> {

}
