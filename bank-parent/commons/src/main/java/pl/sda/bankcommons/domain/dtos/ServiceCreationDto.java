package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ServiceCreationDto {

    private Integer id;
    private ServiceEnum service;
    private Integer number;
    private String title;
    private LocalDateTime date;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String senderAccount;
    private String recipientAccount;
    private Integer accountId;
}
