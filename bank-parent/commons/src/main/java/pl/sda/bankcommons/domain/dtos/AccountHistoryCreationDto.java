package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Valid
public class AccountHistoryCreationDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    private BigDecimal balanceBefore;

    @NotNull(message = "Pole nie może być puste")
    private BigDecimal balanceAfter;

    private Integer accountId;
}
