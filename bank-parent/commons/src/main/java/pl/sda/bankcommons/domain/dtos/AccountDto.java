package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Valid
public class AccountDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    private String number;

    @NotNull(message = "Pole nie może być puste")
    private LocalDateTime createDate;

    @NotNull(message = "Pole nie może być puste")
    private BigDecimal balance;

    private List<ServiceDto> services;

    private List<CardDto> cards;

    private Integer accountCategoryId;

    private List<AccountHistoryDto> accountHistories;
}
