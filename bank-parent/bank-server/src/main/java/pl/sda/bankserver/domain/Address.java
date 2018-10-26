package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "street_name")
    @Size(max = 30)
    private String streetName;
    
    @Column(name = "street_no")
    @Size(max = 10)
    private String streetNo;
    
    @Column(name = "home_no")
    @Size(max = 10)
    private String homeNo;
    
    @Size(max = 30)
    private String city;
    
    @Column(name = "zip_code")
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String zipCode;
    
    @OneToMany(mappedBy = "address")
    private List<Customer> customersAddresses;
    
    @OneToMany(mappedBy = "address")
    private List<Worker> workerAddresses;
    
    @OneToMany(mappedBy = "address")
    private List<Worker> departamentsAddresses;
}
