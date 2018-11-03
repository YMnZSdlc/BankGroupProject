package pl.sda.bankcommons.domain.dtos;

import lombok.Data;
import pl.sda.bankcommons.domain.enums.CardTypeEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Valid
public class CardDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    private CardTypeEnum cardType;

    @NotNull(message = "Pole nie może być puste")
    private Long cardNo;

    @NotNull(message = "Pole nie może być puste")
    //@Pattern(regexp = "^[0-9]{3}$", message = "Numer musi posiadać dokładnie 3 cyfry") doesn't work for Integer
    private Integer cvcCvvCode;

    @NotNull(message = "Pole nie może być puste")
    private LocalDate activationDate;

    @NotNull(message = "Pole nie może być puste")
    private LocalDate expireDate;

    private Integer accountId;
}
