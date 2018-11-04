package pl.sda.bankcommons.domain.dtos;

import lombok.Data;
import pl.sda.bankcommons.domain.enums.ServiceEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Valid
public class ServiceDto {

    private Integer id;

    private ServiceEnum service;

    @NotNull
    private Integer number;

    @Size(max = 30)
    private String title;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private BigDecimal amount;

    @Size(max = 3)
    @NotNull
    private String currency;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Size(max = 23)
    private String senderAccount;

    @Size(max = 23)
    private String recipientAccount;

    private Integer accountId;
}
