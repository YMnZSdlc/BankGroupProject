package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Departments {
    
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
    private Integer deptPhoneNo;
    
    @OneToMany(mappedBy = "department")
    private List<Customer> customers;
    
    @OneToMany(mappedBy = "department")
    private List<Workers> workers;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Addresses addresses;
}
