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
    public void ifDepartamentisValid() {
        Department department = createValidDepartment();
        
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifDepartamenttNameIsNullValidationFails() {
        Department department = createValidDepartment();
        department.setDeptName(null);
        
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDepartamenttNameIsTooLongValidationFails() {
        Department department = createValidDepartment();
        department.setDeptName("Oddzial ktorego nazwa jest stanoczo za dluga");
        
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDepartamenttNumberIsNullValidationFails() {
        Department department = createValidDepartment();
        department.setDeptNo(null);
        
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsNullValidationFails() {
        Department department = createValidDepartment();
        department.setPhoneNumber(null);
    
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsTooLongValidationFails() {
        Department department = createValidDepartment();
        department.setPhoneNumber("666 666 666 666 666");
        
        Set<ConstraintViolation<Department>> violations = validator.validate(department);
        assertEquals(violations.isEmpty(), false);
    }
}

