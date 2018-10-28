package pl.sda.bankcommons.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardTypeEnum {
    MAESTRO("maestro"),

    VISA("visa"),

    MASTERCARD("mastercard");

    private String cardTypeName;

}
