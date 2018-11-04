package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Valid
public class AddressDto {

    private Integer id;

    @Size(min = 3, max = 30, message = "Nazwa ulicy nie może być krótsza niż 3 znaki i nie może przekraczać 30 znaków")
    @NotNull(message = "Pole nie może być puste")
    private String streetName;

    @NotNull(message = "Pole nie może być puste")
    @Pattern(regexp = "^(?=\\S*\\d)\\S{1,10}$", message = "Numer posesji musi zawierać cyfry i nie może " +
            "przekraczać 10 znaków")
    private String streetNo;

    @Pattern(regexp = "^[0-9]{0,10}$", message = "Numer mieszkania nie może przekraczać 10 cyfr")
    private String homeNo;

    @Size(min = 3, max = 30, message = "Nazwa miasta nie może być krótsza niż 3 znaki i nie może przekraczać 30 znaków")
    @NotNull(message = "Pole nie może być puste")
    private String city;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$", message = "Kod pocztowy musi być w formacie '00-000'")
    @NotNull(message = "Pole nie może być puste")
    private String zipCode;

    private List<CustomerDto> customersAddresses;

    private List<WorkerDto> workerAddresses;

    private List<WorkerDto> departmentsAddresses;
}
