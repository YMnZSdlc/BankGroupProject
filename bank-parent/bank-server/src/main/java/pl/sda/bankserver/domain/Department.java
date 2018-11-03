package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Validated
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "dept_name")
    private String deptName;
    
    @Column(name = "dept_no")
    private Integer deptNo;
    
    @Column(name = "dept_phone_no")
    private String phoneNumber;
    
    @OneToMany(mappedBy = "department")
    private List<Customer> customers;
    
    @OneToMany(mappedBy = "department")
    private List<Worker> workers;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
