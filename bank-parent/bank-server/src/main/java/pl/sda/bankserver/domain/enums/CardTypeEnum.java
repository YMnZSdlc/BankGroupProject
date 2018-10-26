package pl.sda.bankserver.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardTypeEnum {
    MAESTRO("maestro"),

    VISTA("vista"),

    MASTERCARD("mastercard"),

    POKER("poker");
    private String cardTypeName;

}
