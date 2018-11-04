package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Card;

import java.time.LocalDate;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByCardTypeOrCardNoOrCvcCvvCodeOrActivationDateOrExpireDate(String cardType, String cardNo, Integer cvcCvvCode, LocalDate activationDate, LocalDate expireDate);

}
