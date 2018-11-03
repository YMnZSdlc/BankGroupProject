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

public class WorkerRegistrationDtoTest {
    
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private WorkerRegistrationDto createValidWorkerRegistrationDto() {
        WorkerRegistrationDto worker = new WorkerRegistrationDto();
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
    
    private WorkerRegistrationDto createEmptyWorkerRegistrationDto() {
        WorkerRegistrationDto worker = new WorkerRegistrationDto();
        return worker;
    }
    
    @Test
    public void ifWorkerRegistrationDtoIsValid() {
        //given
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createEmptyWorkerRegistrationDto();
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setPassword(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setFirstName(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setFirstName("Aa");
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setLastName(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifSalaryIsNullValidationFails() {
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setSalary(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setPesel("123");
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setPesel("123456789123456789");
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setPesel(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setEmploymentDate(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setEmail(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setEmail("aaaaa.com");
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setPhoneNumber("666");
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
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
        WorkerRegistrationDto worker = createValidWorkerRegistrationDto();
        worker.setDateOfBirth(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<WorkerRegistrationDto>> violations = validator.validate(worker);
        for (ConstraintViolation<WorkerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
}