package pl.sda.bankcommons.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Valid
@NoArgsConstructor
@AllArgsConstructor
public class AccountCategoryCreationDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    private String categoryName;

    private List<Integer> accountIds;
}
