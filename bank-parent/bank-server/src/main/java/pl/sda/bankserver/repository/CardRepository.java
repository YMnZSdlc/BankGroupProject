package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findAllByCardTypeOrAndCardNoOrAndCvcCvvCodeAndOrActivationDateAndOrExpireDate(String cardType, String cardNo, String cvcCvvCode, String activationDate, String expireDate);

}
