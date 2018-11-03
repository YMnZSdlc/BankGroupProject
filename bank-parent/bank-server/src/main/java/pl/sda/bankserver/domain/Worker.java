package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.enums.Sex;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Validated
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    private String password;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    private BigDecimal salary;
    
    @Column(unique = true)
    private String pesel;
    
    @Column(name = "employment_date")
    private LocalDate employmentDate;
    
    @Column(unique = true)
    private String email;
    
    @Column(name = "phone_no")
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    private Sex sex;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
