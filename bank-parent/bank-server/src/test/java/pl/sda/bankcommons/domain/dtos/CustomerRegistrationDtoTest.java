package pl.sda.bankcommons.domain.dtos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.bankcommons.domain.enums.Sex;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class CustomerRegistrationDtoTest {
    
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private CustomerRegistrationDto createValidCustomerRegistrationDto() {
        CustomerRegistrationDto customer = new CustomerRegistrationDto();
        customer.setPassword("aaaaAAAA1111");
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setPesel("12345678912");
        customer.setCreateDate(LocalDateTime.now());
        customer.setEmail("aaa@aaa.aa");
        customer.setPhoneNumber("123456789");
        customer.setDateOfBirth(LocalDate.of(1999, 02, 12));
        customer.setSex(Sex.M);
        customer.setAccountIds(null);
        customer.setDepartmentId(null);
        customer.setAddressId(null);
        return customer;
    }
    
    private CustomerRegistrationDto createEmptyCustomerRegistrationDto() {
        CustomerRegistrationDto customer = new CustomerRegistrationDto();
        return customer;
    }
    
    @Test
    public void ifCustomerRegistrationDtoIsValid() {
        //given
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifCustomerRegistrationDtoIsEmpty() {
        //given
        CustomerRegistrationDto customer = createEmptyCustomerRegistrationDto();
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPasswordIsNullValidationFails() {
        //given
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPassword(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPasswordIsTooLongValidationFails() {
        //given
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPassword("aaaaaaaaaaAAAAAAAAAA1111111111");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPasswordIsTooShortValidationFails() {
        //given
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPassword("aaaAAA111");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setFirstName(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setFirstName("Aa");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setLastName(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPesel("123");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPesel("123456789123456789");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPesel(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCreateDateIsNullValidationFails() {
        //given
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setCreateDate(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCreateDateIsFutureValidationFails() {
        //given
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setCreateDate(LocalDateTime.of(2070, 12, 12, 20, 20));
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setEmail(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setEmail("aaaaa.com");
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
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
        CustomerRegistrationDto customer = createValidCustomerRegistrationDto();
        customer.setDateOfBirth(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<CustomerRegistrationDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    private Pattern[] getPatterns(String model) throws NoSuchFieldException {
        Field field = CustomerRegistrationDto.class.getDeclaredField(model);
        return field.getAnnotationsByType(Pattern.class);
    }
    
    @Test
    public void testInvalidPassword() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("password");
        //then
        Assert.assertEquals("aaaaaaaaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidPassword() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("password");
        //then
        Assert.assertEquals("aaaaAAAA1111".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidFirstName() throws NoSuchFieldException {
        //
        Pattern[] annotations = getPatterns("firstName");
        //then
        Assert.assertEquals("aaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidFirstName() throws NoSuchFieldException {
        //
        Pattern[] annotations = getPatterns("firstName");
        //then
        Assert.assertEquals("Aaa".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidPhoneNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("phoneNumber");
        //then
        Assert.assertEquals("111".matches(annotations[0].regexp()), false);
        Assert.assertEquals("aaaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidPhoneNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("phoneNumber");
        //then
        Assert.assertEquals("111222333".matches(annotations[0].regexp()), true);
        Assert.assertEquals("+48 111222333".matches(annotations[0].regexp()), true);
        Assert.assertEquals("111 222 333".matches(annotations[0].regexp()), true);
    }
}