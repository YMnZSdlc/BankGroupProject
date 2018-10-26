package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;
import pl.sda.bankserver.domain.enums.SexEnum;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private Customer createValidCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setPassword("aaaaAAAA1111");
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setPesel("12345678912");
        customer.setCreateDate(LocalDateTime.now());
        customer.setEmail("aaa@aaa.aa");
        customer.setPhoneNumber("123456789");
        customer.setDateOfBirth(LocalDate.of(1999, 02, 12));
        customer.setSex(SexEnum.M);
        customer.setAccounts(null);
        customer.setDepartment(null);
        customer.setAddress(null);
        return customer;
    }
    
    @Test
    public void ifCustomerIsValid() {
        Customer customer = createValidCustomer();
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifPasswordIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setPassword(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setFirstName(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooShortValidationFails() {
        Customer customer = createValidCustomer();
        customer.setFirstName("Aa");
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooLongValidationFails() {
        Customer customer = createValidCustomer();
        customer.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifLastNameIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setLastName(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooShortValidationFails() {
        Customer customer = createValidCustomer();
        customer.setPesel("123");
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooLongtValidationFails() {
        Customer customer = createValidCustomer();
        customer.setPesel("123456789123456789");
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setPesel(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCreateDateIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setCreateDate(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCreateDateIsFutureValidationFails() {
        Customer customer = createValidCustomer();
        customer.setCreateDate(LocalDateTime.of(2070, 12, 12, 20, 20));
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmailIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setEmail(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsNullValidationFails() {
        Customer customer = createValidCustomer();
        customer.setPhoneNumber(null);
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDateOfBirthIsFutureValidationFails() {
        Customer customer = createValidCustomer();
        customer.setDateOfBirth(LocalDate.of(2070, 12, 12));
        
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(violations.isEmpty(), false);
    }
    
    public void passwordRegex(String password, boolean validates) throws NoSuchFieldException {
        Field field = Customer.class.getDeclaredField("password");
        javax.validation.constraints.Pattern[] annotations = field.getAnnotationsByType(javax.validation.constraints.Pattern.class);
        assertEquals(password.matches(annotations[0].regexp()), validates);
    }
    
    @Test
    public void testInvalidPassword() throws NoSuchFieldException {
        passwordRegex("aaaaaaaaa", false);
    }
    
    @Test
    public void testValidPassword() throws NoSuchFieldException {
        passwordRegex("aaaaAAAA1111", true);
    }
    
    public void emailRegex(String email, boolean validates) throws NoSuchFieldException {
        Field field = Customer.class.getDeclaredField("email");
        javax.validation.constraints.Pattern[] annotations = field.getAnnotationsByType(javax.validation.constraints.Pattern.class);
        assertEquals(email.matches(annotations[0].regexp()), validates);
    }
    
    @Test
    public void testInvalidEmail() throws NoSuchFieldException {
        emailRegex("aaaaaa.com", false);
    }
    
    @Test
    public void testValidEmail() throws NoSuchFieldException {
        emailRegex("aaa@aaa.com", true);
    }
    
    public void phoneNumberRegex(String phoneNumber, boolean validates) throws NoSuchFieldException {
        Field field = Customer.class.getDeclaredField("phoneNumber");
        javax.validation.constraints.Pattern[] annotations = field.getAnnotationsByType(javax.validation.constraints.Pattern.class);
        assertEquals(phoneNumber.matches(annotations[0].regexp()), validates);
    }
    
    @Test
    public void testInvalidPhoneNumber() throws NoSuchFieldException {
        phoneNumberRegex("111", false);
        phoneNumberRegex("aaaa", false);
    }
    
    @Test
    public void testValidPhoneNumber() throws NoSuchFieldException {
        phoneNumberRegex("111222333", true);
        phoneNumberRegex("+48 111222333", true);
        phoneNumberRegex("111 222 333", true);
    }
}