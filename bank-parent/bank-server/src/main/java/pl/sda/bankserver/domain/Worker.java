package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import pl.sda.bankcommons.domain.dtos.Sex;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Setter
@NoArgsConstructor
@Validated
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Pattern(regexp = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)\\S{10,20}$")
    @Size(min = 10, max = 20)
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

    @NotNull
    private BigDecimal salary;

    @NotNull
    @Size(min = 11, max = 11)
    private String pesel;

    @NotNull
    @Column(name = "employment_date")
    @Past
    private LocalDate employmentDate;

    @NotNull
    @Pattern(regexp = "^\\w+@\\w+\\.\\w+$")
    private String email;

    @Column(name = "phone_no")
    @NotNull
    @Pattern(regexp = "^(\\+48|)(\\s+|)([0-9]{9}|(\\d{3})\\s+(\\d{3})\\s+(\\d{3}))$")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "date_of_birth")
    @Past
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
