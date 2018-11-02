package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentRegistrationDto {

    private Integer id;
    private String deptName;
    private Integer deptNo;
    private String phoneNumber;
    private List<Integer> customerIds;
    private List<Integer> workerIds;
    private Integer addressId;
}
