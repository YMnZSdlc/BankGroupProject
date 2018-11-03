package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class  AccountRegistrationDto {

    private Integer id;
    private String number;
    private LocalDateTime createDate;
    private BigDecimal balance;
    private List<Integer> serviceIds;
    private List<Integer> cardIds;
    private Integer accountCategoryId;
    private List<Integer> accountHistoryIds;
    private List<Integer> customerIds;
}
