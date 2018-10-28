package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.dtos.ServiceEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Validated
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "service")
    private ServiceEnum service;

    @Column(name = "service_no")
    @NotNull
    private int number;

    @Column(name = "service_title")
    @Size(max = 30)
    private String title;

    @Column(name = "service_date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "service_amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "service_currency")
    @Size(max = 3)
    @NotNull
    private String currency;

    @Column(name = "service_start_time")
    private LocalDateTime startTime;

    @Column(name = "service_end_time")
    private LocalDateTime endTime;

    @Column(name = "service_sender_account")
    @Size(max = 23)
    private String senderAccount;

    @Column(name = "service_recipient_account")
    @Size(max = 23)
    private String recipientAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
