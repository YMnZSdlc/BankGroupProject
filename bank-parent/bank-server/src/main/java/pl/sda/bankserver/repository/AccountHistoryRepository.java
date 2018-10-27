package pl.sda.bankserver.repository;

import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.AccountHistory;

public interface AccountHistoryRepository extends Repository<AccountHistory, Integer> {

}
