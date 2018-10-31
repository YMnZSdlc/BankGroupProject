package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WorkerRegistrationDto {

    private Integer id;
    private String password;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String pesel;
    private LocalDate employmentDate;
    private String email;
    private String phoneNumber;
    private Sex sex;
    private LocalDate dateOfBirth;
    private Integer departmentId;
    private Integer addressId;
}
