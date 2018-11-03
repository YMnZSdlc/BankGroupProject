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

public class CustomerDtoTest {
    
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private CustomerDto createValidCustomerRegistrationDto() {
        CustomerDto customer = new CustomerDto();
        customer.setPassword("aaaaAAAA1111");
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setPesel("12345678912");
        customer.setCreateDate(LocalDateTime.now());
        customer.setEmail("aaa@aaa.aa");
        customer.setPhoneNumber("123456789");
        customer.setDateOfBirth(LocalDate.of(1999, 02, 12));
        customer.setSex(Sex.M);
        customer.setAccounts(null);
        customer.setDepartmentId(null);
        customer.setAddressId(null);
        return customer;
    }
    
    private CustomerDto createEmptyCustomerRegistrationDto() {
        CustomerDto customer = new CustomerDto();
        return customer;
    }
    
    @Test
    public void ifCustomerRegistrationDtoIsValid() {
        //given
        CustomerDto customer = createValidCustomerRegistrationDto();
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createEmptyCustomerRegistrationDto();
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPassword(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPassword("aaaaaaaaaaAAAAAAAAAA1111111111");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPassword("aaaAAA111");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setFirstName(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setFirstName("Aa");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setLastName(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPesel("123");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPesel("123456789123456789");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPesel(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setCreateDate(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setCreateDate(LocalDateTime.of(2070, 12, 12, 20, 20));
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setEmail(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setEmail("aaaaa.com");
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
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
        CustomerDto customer = createValidCustomerRegistrationDto();
        customer.setDateOfBirth(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customer);
        for (ConstraintViolation<CustomerDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    private Pattern[] getPatterns(String model) throws NoSuchFieldException {
        Field field = CustomerDto.class.getDeclaredField(model);
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