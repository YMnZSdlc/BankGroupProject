package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.AccountCategory;

public interface AccountCategoryRepository extends JpaRepository<AccountCategory, Integer> {

}
