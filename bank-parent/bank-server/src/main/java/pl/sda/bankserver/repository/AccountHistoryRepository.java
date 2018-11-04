package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.AccountHistory;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Integer> {

}
