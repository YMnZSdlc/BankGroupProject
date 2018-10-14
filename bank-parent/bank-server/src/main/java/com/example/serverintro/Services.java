package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private ServiceEnum service;
    private int serviceNo;
    private String serviceTitle;
    private LocalDateTime serviceDate;
    private BigDecimal serviceAmount;
    private String serviceCurrency;
    private LocalDateTime serviceStartTime;
    private LocalDateTime serviceEndTime;
    private String serviceSenderAccount;
    private String serviceRecipientAccount;
}
