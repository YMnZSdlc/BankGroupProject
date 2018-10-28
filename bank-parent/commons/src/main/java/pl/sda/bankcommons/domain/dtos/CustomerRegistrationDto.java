package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CustomerRegistrationDto {

    private Integer id;
    private String password;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDateTime createDate;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Sex sex;
    private List<Integer> accountIds;
    private Integer departmentId;
    private Integer addressId;
}
