package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class AccountHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "balance_before")
    @NotNull
    private BigDecimal balanceBefore;
    
    @Column(name = "balance_after")
    @NotNull
    private BigDecimal balanceAfter;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
