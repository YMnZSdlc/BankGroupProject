package pl.sda.bankcommons.domain.dtos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DepartmentRegistrationDtoTest {
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private DepartmentRegistrationDto createValidDepartamentRegistrationDto() {
        DepartmentRegistrationDto department = new DepartmentRegistrationDto();
        department.setDeptNo(1);
        department.setDeptName("Oddzial Psychiatryczny");
        department.setPhoneNumber("666 666 666");
        department.setCustomerIds(null);
        department.setWorkerIds(null);
        department.setAddressId(null);
        return department;
    }
    
    private DepartmentRegistrationDto createEmptyDepartamentRegistrationDto() {
        DepartmentRegistrationDto department = new DepartmentRegistrationDto();
        return department;
    }
    
    @Test
    public void ifDepartamentRegistrationDtoIsValid() {
        //given
        DepartmentRegistrationDto department = createValidDepartamentRegistrationDto();
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
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
        DepartmentRegistrationDto department = createEmptyDepartamentRegistrationDto();
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDepartamenttNameIsNullValidationFails() {
        //given
        DepartmentRegistrationDto department = createValidDepartamentRegistrationDto();
        department.setDeptName(null);
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
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
        DepartmentRegistrationDto department = createValidDepartamentRegistrationDto();
        department.setDeptName("Oddzial ktorego nazwa jest stanoczo za dluga");
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
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
        DepartmentRegistrationDto department = createValidDepartamentRegistrationDto();
        department.setDeptNo(null);
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
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
        DepartmentRegistrationDto department = createValidDepartamentRegistrationDto();
        department.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
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
        DepartmentRegistrationDto department = createValidDepartamentRegistrationDto();
        department.setPhoneNumber("666 666 666 666 666");
        //when
        Set<ConstraintViolation<DepartmentRegistrationDto>> violations = validator.validate(department);
        for (ConstraintViolation<DepartmentRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
}

