package pl.sda.bankcommons.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Valid
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRegistrationDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    private String number;

    @NotNull(message = "Pole nie może być puste")
    private LocalDateTime createDate;

    @NotNull(message = "Pole nie może być puste")
    private BigDecimal balance;

    private List<Integer> serviceIds;

    private List<Integer> cardIds;

    private Integer accountCategoryId;

    private List<Integer> accountHistoryIds;

    private List<Integer> customerIds;
}
