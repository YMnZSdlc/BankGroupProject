package pl.sda.bankcommons.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEnum {
    DEPOSIT(0, "DEPOSIT"),
    LOAN(1, "LOAN"),
    CREDIT(2, "CREDIT"),
    INVESTMENT(3, "INVESTMENT"),
    PAYMENT(4, "PAYMENT"),
    WITHDRAWAL(5, "WITHDRAWAL");

    private int numberValue;
    private String plName;
}
