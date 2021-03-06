package pl.sda.bankserver.mappers;

import pl.sda.bankcommons.domain.dtos.*;
import pl.sda.bankcommons.domain.enums.CardTypeEnum;
import pl.sda.bankcommons.domain.enums.ServiceEnum;
import pl.sda.bankcommons.domain.enums.Sex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;
import static java.time.LocalDateTime.of;

public class FakeDtos {
    static List<ServiceDto> serviceDtoList() {
        List<ServiceDto> serviceDtoList = new ArrayList<>();
        serviceDtoList.add(createServiceDto());
        return serviceDtoList;
    }

    static List<CustomerDto> customerDtoList() {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customerDtoList.add(createCustomerDto());
        return customerDtoList;
    }

    static List<WorkerDto> workerDtoList() {
        List<WorkerDto> workerDtoList = new ArrayList<>();
        workerDtoList.add(createWorkerDto());
        return workerDtoList;
    }

    static List<AccountDto> accountDtoList() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountDtoList.add(createAccountDto());
        return accountDtoList;
    }

    static List<DepartmentDto> departmentDtoList() {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        departmentDtoList.add(createDepartmentDto());
        return departmentDtoList;
    }

    static List<CardDto> cardDtoList() {
        List<CardDto> cardDtoList = new ArrayList<>();
        cardDtoList.add(createCardDto());
        return cardDtoList;
    }

    static List<AccountHistoryDto> accountHistoryDtoList() {
        List<AccountHistoryDto> accountHistoryDtoList = new ArrayList<>();
        accountHistoryDtoList.add(createAccountHistoryDto());
        return accountHistoryDtoList;
    }

    static AccountCategoryDto createAccountCategoryDto() {
        AccountCategoryDto dto = new AccountCategoryDto();
        dto.setId(5678);
        dto.setCategoryName("EFGH");
        dto.setAccountId(1234);
        return dto;
    }

    static AccountDto createAccountDto() {
        AccountDto dto = new AccountDto();
        dto.setId(478);
        dto.setNumber("2643544114631845");
        dto.setCreateDate(of(2017, 10, 20, 15, 45));
        dto.setBalance(new BigDecimal("156"));
        dto.setServices(serviceDtoList());
        dto.setCards(cardDtoList());
        dto.setAccountCategoryId(534);
        dto.setAccountHistories(accountHistoryDtoList());
        return dto;
    }

    static AccountHistoryDto createAccountHistoryDto() {
        AccountHistoryDto dto = new AccountHistoryDto();
        dto.setId(62384);
        dto.setBalanceBefore(new BigDecimal("16435"));
        dto.setBalanceAfter(new BigDecimal("164354"));
        dto.setAccountId(2463);
        return dto;
    }

    static AddressDto createAddressDto() {
        AddressDto dto = new AddressDto();
        dto.setStreetName("Piotrkowska");
        dto.setStreetNo("59");
        dto.setHomeNo("1");
        dto.setCity("Łódź");
        dto.setZipCode("54-614");
        dto.setCustomersAddresses(customerDtoList());
        dto.setWorkerAddresses(workerDtoList());
        dto.setDepartmentsAddresses(workerDtoList());
        return dto;
    }

    static CardDto createCardDto() {
        CardDto dto = new CardDto();
        dto.setId(364);
        dto.setCardType(CardTypeEnum.VISA);
        dto.setCardNo(34131844L);
        dto.setCvcCvvCode(514);
        dto.setActivationDate(of(2017, 10, 20));
        dto.setExpireDate(of(2019, 10, 20));
        dto.setAccountId(31);
        return dto;
    }

    static CustomerDto createCustomerDto() {
        CustomerDto dto = new CustomerDto();
        dto.setId(3184);
        dto.setPassword("L31346ASFsa");
        dto.setFirstName("Andzej");
        dto.setLastName("Dudeł");
        dto.setPesel("72051645217");
        dto.setCreateDate(of(2017, 10, 20, 15, 45));
        dto.setEmail("kafcndhad@wp.pl");
        dto.setPhoneNumber("525458216");
        dto.setDateOfBirth(of(1972, 05, 16));
        dto.setSex(Sex.M);
        dto.setAccounts(accountDtoList());
        dto.setDepartmentId(3345);
        dto.setAddressId(4342);
        return dto;
    }

    static DepartmentDto createDepartmentDto() {
        DepartmentDto dto = new DepartmentDto();
        dto.setDeptName("Centrala");
        dto.setDeptNo(47);
        dto.setPhoneNumber("745896325");
        dto.setCustomers(customerDtoList());
        dto.setWorkers(workerDtoList());
        dto.setAddressId(13);
        return dto;
    }

    static ServiceDto createServiceDto() {
        ServiceDto dto = new ServiceDto();
        dto.setId(87456);
        dto.setService(ServiceEnum.CREDIT);
        dto.setNumber(785412563);
        dto.setTitle("Title");
        dto.setDate(of(2017, 10, 20, 15, 45));
        dto.setAmount(new BigDecimal("78456"));
        dto.setCurrency("currency");
        dto.setStartTime(of(2017, 10, 20, 15, 45));
        dto.setEndTime(of(2018, 10, 20, 15, 45));
        dto.setSenderAccount("senderAccount");
        dto.setRecipientAccount("recipientAccount");
        dto.setAccountId(8465123);
        return dto;
    }

    static WorkerDto createWorkerDto() {
        WorkerDto dto = new WorkerDto();
        dto.setId(7452);
        dto.setPassword("L31346ASFsa");
        dto.setFirstName("Kubuś");
        dto.setLastName("Dobrog");
        dto.setSalary(new BigDecimal("1745"));
        dto.setPesel("98021778569");
        dto.setEmploymentDate(of(2017, 11, 16));
        dto.setEmail("dobrogj@amorek.pl");
        dto.setPhoneNumber("895645127");
        dto.setSex(Sex.M);
        dto.setDateOfBirth(of(1998, 2, 17));
        dto.setDepartmentId(798653);
        dto.setAddressId(7653);
        return dto;
    }
}
