package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@Validated
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "acc_no")
    @NotNull
    private String number;

    @Column(name = "create_date")
    @NotNull
    private LocalDateTime createDate;

    @Column(name = "acc_balance")
    @NotNull
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    private List<Service> services;

    @OneToMany(mappedBy = "account")
    private List<Card> cards;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private AccountCategory accountCategory;

    @OneToMany(mappedBy = "account")
    private List<AccountHistory> accountHistories;

    @ManyToMany
    @JoinTable(
            name = "customer_accounts",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id")
    )
    private List<Customer> customers;



}
