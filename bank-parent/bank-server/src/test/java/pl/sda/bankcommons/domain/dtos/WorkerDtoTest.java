package pl.sda.bankcommons.domain.dtos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.bankcommons.domain.enums.Sex;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class WorkerDtoTest {
    
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private WorkerDto createValidWorkerRegistrationDto() {
        WorkerDto worker = new WorkerDto();
        worker.setPassword("aaaaAAAA1111");
        worker.setFirstName("Jan");
        worker.setLastName("Kowalski");
        worker.setSalary(BigDecimal.valueOf(3000));
        worker.setPesel("12345678912");
        worker.setEmploymentDate(LocalDate.of(2010, 02, 12));
        worker.setEmail("aaa@aaa.aa");
        worker.setPhoneNumber("123456789");
        worker.setDateOfBirth(LocalDate.of(1999, 02, 12));
        worker.setSex(Sex.M);
        worker.setDepartmentId(null);
        worker.setAddressId(null);
        return worker;
    }
    
    private WorkerDto createEmptyWorkerRegistrationDto() {
        WorkerDto worker = new WorkerDto();
        return worker;
    }
    
    @Test
    public void ifWorkerRegistrationDtoIsValid() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifWorkerRegistrationDtoIsEmpty() {
        //given
        WorkerDto worker = createEmptyWorkerRegistrationDto();
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPasswordIsNullValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setPassword(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsNullValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setFirstName(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooShortValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setFirstName("Aa");
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooLongValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifLastNameIsNullValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setLastName(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifSalaryIsNullValidationFails() {
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setSalary(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooShortValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setPesel("123");
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooLongtValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setPesel("123456789123456789");
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsNullValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setPesel(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmploymentDateIsFutureValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setEmploymentDate(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmailIsNullValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setEmail(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmailIsInvalidEmailValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setEmail("aaaaa.com");
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsNullValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsWrongValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setPhoneNumber("666");
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDateOfBirthIsFutureValidationFails() {
        //given
        WorkerDto worker = createValidWorkerRegistrationDto();
        worker.setDateOfBirth(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<WorkerDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
}