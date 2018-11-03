package pl.sda.bankserver.domain;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.enums.ServiceEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
