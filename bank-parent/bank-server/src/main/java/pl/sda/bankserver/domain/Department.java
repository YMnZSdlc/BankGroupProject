package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Setter
@NoArgsConstructor
@Validated
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dept_name")
    @NotNull
    @Size(max = 30)
    private String deptName;

    @NotNull
    @Column(name = "dept_no")
    private Integer deptNo;

    @NotNull
    @Column(name = "dept_phone_no")
    @Pattern(regexp = "^(\\+48|)(\\s+|)([0-9]{9}|(\\d{3})\\s+(\\d{3})\\s+(\\d{3}))$")
    private String phoneNumber;

    @OneToMany(mappedBy = "department")
    private List<Customer> customers;

    @OneToMany(mappedBy = "department")
    private List<Worker> workers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
