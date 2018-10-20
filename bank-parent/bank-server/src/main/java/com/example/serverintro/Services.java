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
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private ServiceEnum service;
    @Column(name = "service_no")
    private int number;
    @Column(name = "service_title")
    private String title;
    @Column(name = "service_date")
    private LocalDateTime date;
    @Column(name = "service_amount")
    private BigDecimal amount;
    @Column(name = "service_currency")
    private String currency;
    @Column(name = "service_start_time")
    private LocalDateTime startTime;
    @Column(name = "service_end_time")
    private LocalDateTime endTime;
    @Column(name = "service_sender_account")
    private String senderAccount;
    @Column(name = "service_recipient_account")
    private String recipientAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
