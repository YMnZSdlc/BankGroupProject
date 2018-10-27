package pl.sda.bankserver.repository;

import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Card;

public interface CardRepository extends Repository<Card, Integer> {

}
