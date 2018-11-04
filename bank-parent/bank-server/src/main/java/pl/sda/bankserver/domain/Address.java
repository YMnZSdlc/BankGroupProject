package pl.sda.bankserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
 @Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_no")
    private String streetNo;

    @Column(name = "home_no")
    private String homeNo;

    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "address")
    private List<Customer> customersAddresses;

    @OneToMany(mappedBy = "address")
    private List<Worker> workerAddresses;

    @OneToMany(mappedBy = "address")
    private List<Department> departmentsAddresses;
}
