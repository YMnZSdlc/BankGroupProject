package pl.sda.bankserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_category")
@Validated
@Builder
public class AccountCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "accountCategory")
    private Account account;
}
