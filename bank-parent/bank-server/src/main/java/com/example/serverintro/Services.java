package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private ServiceEnum service;
    @Column(name = "service_no")
    private int serviceNo;
    @Column(name = "service_title")
    private String serviceTitle;
    @Column(name = "service_date")
    private LocalDateTime serviceDate;
    @Column(name = "service_amount")
    private BigDecimal serviceAmount;
    @Column(name = "service_currency")
    private String serviceCurrency;
    @Column(name = "service_start_time")
    private LocalDateTime serviceStartTime;
    @Column(name = "service_end_time")
    private LocalDateTime serviceEndTime;
    @Column(name = "service_sender_account")
    private String serviceSenderAccount;
    @Column(name = "service_recipient_account")
    private String serviceRecipientAccount;
}
