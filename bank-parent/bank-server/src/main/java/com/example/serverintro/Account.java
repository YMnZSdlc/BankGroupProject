package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "acc_no")
    private String accNo;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "acc_balance")
    private BigDecimal accBalance;
}
