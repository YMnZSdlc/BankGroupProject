package pl.sda.bankclient.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String password;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDateTime createDate;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
