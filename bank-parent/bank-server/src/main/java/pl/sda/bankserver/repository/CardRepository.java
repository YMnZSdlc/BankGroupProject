package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
