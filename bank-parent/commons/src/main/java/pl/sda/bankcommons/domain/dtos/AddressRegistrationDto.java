package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AddressRegistrationDto {

    private Integer id;
    private String streetName;
    private String streetNo;
    private String homeNo;
    private String city;
    private String zipCode;
    private List<Integer> customerAddressIds;
    private List<Integer> workerAddressIds;
    private List<Integer> departmentAddressIds;
}
