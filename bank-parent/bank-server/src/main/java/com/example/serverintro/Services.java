package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private DepositsEnum deposits;
    private LoansEnum loans;
    private CreditsEnum credits;
    private InvestmentsEnum investments;
}
