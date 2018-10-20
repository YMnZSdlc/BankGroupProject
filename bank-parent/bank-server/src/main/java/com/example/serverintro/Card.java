package com.example.serverintro;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "card_no")
    private Long cardNo;
    @Column(name = "cvc_cvv_code")
    private Integer cvcCvvCode;
    @Column(name = "activation_date")
    private Date activationDate;
    @Column(name = "expire_date")
    private Date expireDate;
    @Enumerated(EnumType.STRING)
    @Column(name="card_type")
    private CardTypeEnum cardType;

}
