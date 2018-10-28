package pl.sda.bankserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Validated
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "street_name")
    @Size(max = 30)
    @NotNull
    private String streetName;
    
    @Column(name = "street_no")
    @Size(max = 10)
    @NotNull
    @Pattern(regexp = "^(?=\\S*\\d)\\S{1,10}$")
    private String streetNo;
    
    @Column(name = "home_no")
    @Size(max = 10)
    private String homeNo;
    
    @Size(max = 30)
    @NotNull
    private String city;
    
    @Column(name = "zip_code")
    @Size(max = 6, min = 6)
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    @NotNull
    private String zipCode;
    
    @OneToMany(mappedBy = "address")
    private List<Customer> customersAddresses;
    
    @OneToMany(mappedBy = "address")
    private List<Worker> workerAddresses;
    
    @OneToMany(mappedBy = "address")
    private List<Worker> departamentsAddresses;
}
