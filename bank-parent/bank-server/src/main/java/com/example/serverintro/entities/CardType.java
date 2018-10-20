package com.example.serverintro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardType {
    MAESTRO("maestro"),

    VISTA("vista"),

    MASTERCARD("mastercard"),

    POKER("poker");
    private String cardTypeName;

}
