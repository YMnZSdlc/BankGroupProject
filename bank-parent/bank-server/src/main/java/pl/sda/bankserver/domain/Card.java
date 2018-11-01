package pl.sda.bankserver.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.dtos.CardTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Validated
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    @NotNull
    private CardTypeEnum cardType;

    @Column(name = "card_no")
    @NotNull
    private Long cardNo;

    @Column(name = "cvc_cvv_code")
    @NotNull
    @Size(min = 3, max = 3)
    private Integer cvcCvvCode;

    @Column(name = "activation_date")
    @NotNull
    private LocalDate activationDate;

    @Column(name = "expire_date")
    @NotNull
    private LocalDate expireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
