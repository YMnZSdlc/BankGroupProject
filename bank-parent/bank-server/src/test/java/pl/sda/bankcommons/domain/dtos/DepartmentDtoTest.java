package pl.sda.bankcommons.domain.dtos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DepartmentDtoTest {
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private DepartmentDto createValidDepartamentRegistrationDto() {
        DepartmentDto department = new DepartmentDto();
        department.setDeptNo(1);
        department.setDeptName("Oddzial Psychiatryczny");
        department.setPhoneNumber("666 666 666");
        department.setCustomers(null);
        department.setWorkers(null);
        department.setAddressId(null);
        return department;
    }
    
    private DepartmentDto createEmptyDepartamentRegistrationDto() {
        DepartmentDto department = new DepartmentDto();
        return department;
    }
    
    @Test
    public void ifDepartamentRegistrationDtoIsValid() {
        //given
        DepartmentDto department = createValidDepartamentRegistrationDto();
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifDepartamentRegistrationDtoIsEmpty() {
        //given
        DepartmentDto department = createEmptyDepartamentRegistrationDto();
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    @Ignore
    public void ifDepartamenttNameIsNullValidationFails() {
        //given
        DepartmentDto department = createValidDepartamentRegistrationDto();
        department.setDeptName(null);
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDepartamenttNameIsTooLongValidationFails() {
        //given
        DepartmentDto department = createValidDepartamentRegistrationDto();
        department.setDeptName("Oddzial ktorego nazwa jest stanoczo za dluga");
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDepartamenttNumberIsNullValidationFails() {
        //given
        DepartmentDto department = createValidDepartamentRegistrationDto();
        department.setDeptNo(null);
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
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
        DepartmentDto department = createValidDepartamentRegistrationDto();
        department.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsTooLongValidationFails() {
        //given
        DepartmentDto department = createValidDepartamentRegistrationDto();
        department.setPhoneNumber("666 666 666 666 666");
        //when
        Set<ConstraintViolation<DepartmentDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
}

