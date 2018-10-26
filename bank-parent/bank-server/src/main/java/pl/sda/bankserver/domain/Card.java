package pl.sda.bankserver.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.bankserver.domain.enums.CardTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardTypeEnum cardType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}