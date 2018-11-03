package pl.sda.bankserver.domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.enums.CardTypeEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Validated
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardTypeEnum cardType;
    
    @Column(name = "card_no")
    private Long cardNo;
    
    @Column(name = "cvc_cvv_code")
    private Integer cvcCvvCode;
    
    @Column(name = "activation_date")
    private LocalDate activationDate;
    
    @Column(name = "expire_date")
    private LocalDate expireDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
