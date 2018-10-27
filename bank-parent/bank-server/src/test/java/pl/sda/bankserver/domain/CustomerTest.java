package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;
import pl.sda.bankserver.domain.enums.Sex;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
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
        customer.setSex(Sex.M);
        customer.setAccounts(null);
        customer.setDepartment(null);
        customer.setAddress(null);
        return customer;
    }
    
    @Test
    public void ifCustomerIsValid() {
        //given
        Customer customer = createValidCustomer();
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifPasswordIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setPassword(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setFirstName(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooShortValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setFirstName("Aa");
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifFirstNameIsTooLongValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setFirstName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifLastNameIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setLastName(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooShortValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setPesel("123");
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsTooLongtValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setPesel("123456789123456789");
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPeselIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setPesel(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCreateDateIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setCreateDate(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCreateDateIsFutureValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setCreateDate(LocalDateTime.of(2070, 12, 12, 20, 20));
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifEmailIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setEmail(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifPhoneNumberIsNullValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setPhoneNumber(null);
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifDateOfBirthIsFutureValidationFails() {
        //given
        Customer customer = createValidCustomer();
        customer.setDateOfBirth(LocalDate.of(2070, 12, 12));
        //when
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    private Pattern[] getPatterns(String model) throws NoSuchFieldException {
        Field field = Customer.class.getDeclaredField(model);
        return field.getAnnotationsByType(Pattern.class);
    }
    
    @Test
    public void testInvalidPassword() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("password");
        //then
        assertEquals("aaaaaaaaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidPassword() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("password");
        //then
        assertEquals("aaaaAAAA1111".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidEmail() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("email");
        //then
        assertEquals("aaaaaa.com".matches(annotations[0].regexp()), false);
    }

    @Test
    public void testValidEmail() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("email");
        //then
        assertEquals("aaa@aaa.com".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidPhoneNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("phoneNumber");
        //then
        assertEquals("111".matches(annotations[0].regexp()), false);
        assertEquals("aaaa".matches(annotations[0].regexp()), false);
    }

    @Test
    public void testValidPhoneNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("phoneNumber");
        //then
        assertEquals("111222333".matches(annotations[0].regexp()), true);
        assertEquals("+48 111222333".matches(annotations[0].regexp()), true);
        assertEquals("111 222 333".matches(annotations[0].regexp()), true);
    }
}