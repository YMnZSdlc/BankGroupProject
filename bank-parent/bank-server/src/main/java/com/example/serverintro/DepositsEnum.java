package com.example.serverintro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DepositsEnum {

    PODSTAWOWY_RACHUNEK_PLATNICZY(0, "PODSTAWOWY RACHUNEK PŁATNICZY"),
    SYSTEMATYCZNI_ZYSKUJA(1, "SYSTEMATYCZNI ZYSKUJĄ"),
    ZLOTY_KUFEREK(2, "ZŁOTY KUFEREK"),
    ZLOTY_PORTFEL(3, "ZŁOTY PORTFEL");

    private int numberValue;
    private String plName;
}
