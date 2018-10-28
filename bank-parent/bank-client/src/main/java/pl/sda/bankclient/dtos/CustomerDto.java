package pl.sda.bankclient.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.bankserver.domain.enums.Sex;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDateTime createDate;
    private String email;
    private String phoneNo;
    private LocalDate dateOfBirth;
    private Sex sex;
}
