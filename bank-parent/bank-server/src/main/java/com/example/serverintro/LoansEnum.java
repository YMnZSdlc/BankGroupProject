package com.example.serverintro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoansEnum {

    TRADYCJA_JESIENIA(0, "TRADYCJA JESIENIĄ"),
    ZAKUPOZYCZKA(1, "ZAKUPOŻYCZKA"),
    ZREALIZUJ_PLANY(2, "ZREALIZUJ PLANY"),
    POD_PARASOLEM_UBEZPIECZENIOWYM(3, "POD PARASOLEM UBEZPIECZENIOWYM"),
    MADRY_WYBOR(4, "MĄDRY WYBÓR"),
    POZYCZKA_ODNAWIALNA_CHWILOWKA(5, "POŻYCZKA ODNAWIALNA CHWILÓWKA");

    private int numberValue;
    private String plName;
}
