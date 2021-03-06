package pl.sda.bankserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "acc_no", unique = true)
    private String number;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "acc_balance")
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
}
