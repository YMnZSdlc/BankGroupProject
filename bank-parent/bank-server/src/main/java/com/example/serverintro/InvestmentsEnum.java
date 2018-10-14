package com.example.serverintro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvestmentsEnum {
    LOKATA_TERMINOWA(0, "LOKATA TERMINOWA"),
    LOKATA_PRAKTYCZNA(1, "LOKATA PRAKTYCZNA"),
    LOKATA_RENTIERSKA(2, "LOKATA RENTIERSKA"),
    LOKATA_SYSTEMATYCZNEGO_OSZCZEDZANIA(3, "LOKATA SYSTEMATYCZNEGO OSZCZĘDZANIA"),
    LOKATA_EKO(4, "EKO LOKATA");

    private int numberValue;
    private String plName;
}
