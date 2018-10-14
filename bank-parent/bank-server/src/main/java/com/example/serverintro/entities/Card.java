package com.example.serverintro.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "card_no")
    Integer cardNo;
    @Column(name = "cvc_cvv_code")
    Integer cvcCvvCode;
}
