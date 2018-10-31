package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountHistoryCreationDto {

    private Integer id;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    private Integer accountId;
}
