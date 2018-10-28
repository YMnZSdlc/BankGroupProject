package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CardRegistrationDto {

    private Integer id;
    private CardTypeEnum cardType;
    private Long cardNo;
    private Integer cvcCvvCode;
    private LocalDate activationDate;
    private LocalDate expireDate;
    private Integer accountId;
}
