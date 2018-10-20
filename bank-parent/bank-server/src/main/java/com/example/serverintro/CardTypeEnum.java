package com.example.serverintro;

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
