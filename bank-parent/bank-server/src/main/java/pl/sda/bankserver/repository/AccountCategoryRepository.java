package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.AccountCategory;

import java.util.List;

public interface AccountCategoryRepository extends JpaRepository<AccountCategory, Integer> {
    List<AccountCategory> findAll();

    List<AccountCategory> findAllByCategoryName(String categoryName);
}
