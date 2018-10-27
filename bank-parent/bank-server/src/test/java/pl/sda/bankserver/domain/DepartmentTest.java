package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class DepartmentTest {
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private Department createValidDepartment() {
        Department department = new Department();
        department.setId(1);
        department.setDeptNo(1);
        department.setDeptName("Oddzial Psychiatryczny");
        department.setPhoneNumber("666 666 666");
        department.setCustomers(null);
        department.setWorkers(null);
        department.setAddress(null);
        return department;
    }
    
    @Test
    private void ifDepartamentisValid() {
        //given
        Department department = createValidDepartment();
        //when
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        //then
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    private void ifDepartamenttNameIsNullValidationFails() {
        //given
        Department department = createValidDepartment();
        department.setDeptName(null);
        //when
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    private void ifDepartamenttNameIsTooLongValidationFails() {
        //given
        Department department = createValidDepartment();
        department.setDeptName("Oddzial ktorego nazwa jest stanoczo za dluga");
        //when
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    private void ifDepartamenttNumberIsNullValidationFails() {
        //given
        Department department = createValidDepartment();
        department.setDeptNo(null);
        //when
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    private void ifPhoneNumberIsNullValidationFails() {
        //given
        Department department = createValidDepartment();
        department.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    private void ifPhoneNumberIsTooLongValidationFails() {
        //given
        Department department = createValidDepartment();
        department.setPhoneNumber("666 666 666 666 666");
        //when
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        //then
        assertEquals(violations.isEmpty(), false);
    }
}

