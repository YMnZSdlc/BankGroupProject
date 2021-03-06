package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Valid
public class AccountCategoryDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    private String categoryName;
    private Integer accountId;
}
