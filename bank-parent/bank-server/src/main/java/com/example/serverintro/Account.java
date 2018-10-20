package com.example.serverintro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "acc_no")
    private String number;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "acc_balance")
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    private List<Services> services;

    @OneToMany(mappedBy = "account")
    private List<Card> cards;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private AccountCategory accountCategory;

}
