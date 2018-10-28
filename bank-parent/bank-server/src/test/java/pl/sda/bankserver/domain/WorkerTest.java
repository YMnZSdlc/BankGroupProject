package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.Sex;

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
        worker.setSex(Sex.M);
        worker.setDepartment(null);
        worker.setAddress(null);
        return worker;
    }

    @Test
    public void ifWorkerIsValid() {
        //given
        Worker worker = createValidWorker();
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), true);
    }

    @Test
    public void ifPasswordIsNullValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setPassword(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifFirstNameIsNullValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setFirstName(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifFirstNameIsTooShortValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setFirstName("Aa");
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifFirstNameIsTooLongValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifLastNameIsNullValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setLastName(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifSalaryIsNullValidationFails() {
        Worker worker = createValidWorker();
        worker.setSalary(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifPeselIsTooShortValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setPesel("123");
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifPeselIsTooLongtValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setPesel("123456789123456789");
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifPeselIsNullValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setPesel(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifEmploymentDateIsFutureValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setEmploymentDate(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifEmailIsNullValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setEmail(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifPhoneNumberIsNullValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    @Test
    public void ifDateOfBirthIsFutureValidationFails() {
        //given
        Worker worker = createValidWorker();
        worker.setDateOfBirth(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<Worker>> violations = validator.validate(worker);
        //then
        assertEquals(violations.isEmpty(), false);
    }

}