package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Account;
import pl.sda.bankserver.domain.AccountHistory;

import java.util.List;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Integer> {
List<AccountHistory>findAll();
List<AccountHistory>findAllById(Integer id);

    List<AccountHistory> findAllByBalanceBeforeAndOrBalanceAfter(String balanceBefore, String balanceAfter);
}
