package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Valid
public class DepartmentDto {

    private Integer id;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 3, max = 30, message = "Nazwa oddziału nie może być krótsza niż 3 znaki i nie może przekraczać 30 " +
            "znaków")
    private String deptName;

    @NotNull(message = "Pole nie może być puste")
    private Integer deptNo;

    @NotNull(message = "Pole nie może być puste")
    @Pattern(regexp = "^(\\+48|)(\\s+|)([0-9]{9}|(\\d{3})\\s+(\\d{3})\\s+(\\d{3}))$", message = "Numer telefonu musi " +
            "posiadać 9 cyfr")
    private String phoneNumber;

    private List<CustomerDto> customers;

    private List<WorkerDto> workers;

    private Integer addressId;
}
