package pl.sda.bankserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acount_category")
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
