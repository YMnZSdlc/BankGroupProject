package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankserver.domain.enums.SexEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Customers")
@Validated
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @Pattern(regexp = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)\\S{10,20}$")
    private String password;
    
    @Column(name = "first_name")
    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[A-Z][a-z]+$")
    private String firstName;
    
    @Column(name = "last_name")
    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[A-Z][a-z]+$")
    private String lastName;
    
    @Column(name = "pesel")
    @NotNull
    @Size(min = 11, max = 11)
    private String pesel;
    
    @Column(name = "create_date")
    @NotNull
    @Past
    private LocalDateTime createDate;
    
    @Column(name = "email")
    @NotNull
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+$")
    private String email;
    
    @Column(name = "phone_no")
    @NotNull
    @Pattern(regexp = "^(\\+48|)(\\s+|)([0-9]{9}|(\\d{3})\\s+(\\d{3})\\s+(\\d{3}))$")
    private String phoneNumber;
    
    @Column(name = "date_of_birth")
    @Past
    private LocalDate dateOfBirth;
    
    @Enumerated(EnumType.STRING)
    private SexEnum sex;
    
    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
