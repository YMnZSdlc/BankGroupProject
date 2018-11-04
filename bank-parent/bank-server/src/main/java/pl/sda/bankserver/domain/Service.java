package pl.sda.bankserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.enums.ServiceEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
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
