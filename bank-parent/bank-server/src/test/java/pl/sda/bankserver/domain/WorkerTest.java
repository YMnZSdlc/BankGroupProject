package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;
import pl.sda.bankserver.domain.enums.SexEnum;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WorkerTest {
    
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private Worker createValidWorker() {
        Worker worker = new Worker();
        worker.setId(1);
        worker.setPassword("aaaaAAAA1111");
        worker.setFirstName("Jan");
        worker.setLastName("Kowalski");
        worker.setSalary(BigDecimal.valueOf(3000));
        worker.setPesel("12345678912");
        worker.setEmploymentDate(LocalDate.of(2010, 02, 12));
        worker.setEmail("aaa@aaa.aa");
        worker.setPhoneNumber("123456789");
        worker.setDateOfBirth(LocalDate.of(1999, 02, 12));
        worker.setSex(SexEnum.M);
        worker.setDepartment(null);
        worker.setAddress(null);
        return worker;
    }
    
    @Test
    public void ifWorkerIsValid() {
        Worker worker = createValidWorker();
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifPasswordIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setPassword(null);
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setFirstName(null);
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooShortValidationFails() {
        Worker worker = createValidWorker();
        worker.setFirstName("Aa");
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooLongValidationFails() {
        Worker worker = createValidWorker();
        worker.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifLastNameIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setLastName(null);
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifSalaryIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setSalary(null);
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooShortValidationFails() {
        Worker worker = createValidWorker();
        worker.setPesel("123");
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooLongtValidationFails() {
        Worker worker = createValidWorker();
        worker.setPesel("123456789123456789");
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setPesel(null);
        
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmploymentDateIsFutureValidationFails() {
        Worker worker = createValidWorker();
        worker.setEmploymentDate(LocalDate.of(2070, 12, 12));
    
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmailIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setEmail(null);
    
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setPhoneNumber(null);
    
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDateOfBirthIsFutureValidationFails() {
        Worker worker = createValidWorker();
        worker.setDateOfBirth(LocalDate.of(2070, 12, 12));
    
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        assertEquals(violations.isEmpty(), false);
    }
    
}