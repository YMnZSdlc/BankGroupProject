package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "account_category")
@Validated
public class AccountCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "category_name")
    @NotNull
    private String categoryName;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "accountCategory")
    private Account account;
}