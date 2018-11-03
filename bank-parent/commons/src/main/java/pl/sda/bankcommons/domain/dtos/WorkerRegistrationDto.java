package pl.sda.bankcommons.domain.dtos;

import lombok.Data;
import pl.sda.bankcommons.domain.enums.Sex;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Valid
public class WorkerRegistrationDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    @Pattern(regexp = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)\\S{10,20}$", message = "Hasło musi posiadać małe i duże" +
            " litery, oraz cyfry, a także nie może być krótsze niż 10 znaków i nie może przekraczać 20 znaków")
    private String password;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 3, max = 30, message = "Imię nie może być krótsze niż 3 znaki i nie może przekraczać 30 znaków")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Imię musi zaczynać się od Dużej litery")
    private String firstName;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 3, max = 30, message = "Nazwisko nie może być krótsze niż 3 znaki i nie może przekraczać 30 znaków")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Nazwisko musi zaczynać się od Dużej litery")
    private String lastName;

    @NotNull(message = "Pole nie może być puste")
    private BigDecimal salary;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 11, max = 11, message = "Pesel musi posiadać dokładnie 11 znaków")
    private String pesel;

    @NotNull(message = "Pole nie może być puste")
    @Past(message = "Data nie może pochodzić z przyszłości")
    private LocalDate employmentDate;

    @NotNull(message = "Pole nie może być puste")
    @Email(message = "Wprowadź poprawny format E-mail")
    private String email;

    @NotNull(message = "Pole nie może być puste")
    @Pattern(regexp = "^(\\+48|)(\\s+|)([0-9]{9}|(\\d{3})\\s+(\\d{3})\\s+(\\d{3}))$", message = "Numer telefonu musi " +
            "posiadać 9 cyfr")
    private String phoneNumber;

    private Sex sex;

    @Past(message = "Data nie może pochodzić z przyszłości")
    private LocalDate dateOfBirth;

    private Integer departmentId;

    private Integer addressId;
}
