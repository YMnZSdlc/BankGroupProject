package com.example.serverintro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CreditsEnum {

    KREDYT_HIPOTECZNY_DO_20LAT(0, "KREDYT HIPOTECZNY DO 20 LAT"),
    KREDYT_HIPOTECZNY_DO_25LAT(1, "KREDYT HIPOTECZNY DO 25 LAT"),
    KREDYT_HIPOTECZNY_DO_30LAT(2, "KREDYT HIPOTECZNY DO 30 LAT"),
    KREDYT_INWESTYCYJNY(3, "KREDYT INWESTYCYJNY"),
    KREDYT_OBROTOWY(4, "KREDYT OBROTOWY"),
    KREDYT_ZIELONA_INWESTYCJA(5, "KREDYT ZIELONA INWESTYCJA");

    private int numberValue;
    private String plName;
}
