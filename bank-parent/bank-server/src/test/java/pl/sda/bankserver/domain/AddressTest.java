package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AddressTest {
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private Address createValidAddress() {
        Address address = new Address();
        address.setId(1);
        address.setStreetName("Nigdzie");
        address.setStreetNo("666Z");
        address.setHomeNo("666");
        address.setCity("Zgierz");
        address.setZipCode("00-666");
        address.setCustomersAddresses(null);
        address.setDepartamentsAddresses(null);
        address.setWorkerAddresses(null);
        
        return address;
    }
    
    @Test
    public void ifAddressisValid() {
        Address address = createValidAddress();
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifStreetNameIsNullValidationFails() {
        Address address = createValidAddress();
        address.setStreetName(null);
    
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNameIsTooLongValidationFails() {
        Address address = createValidAddress();
        address.setStreetName("Ulica ktorej nazwa jest stanowczo za dluga");
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNumberIsNullValidationFails() {
        Address address = createValidAddress();
        address.setStreetNo(null);
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNumberIsTooLongValidationFails() {
        Address address = createValidAddress();
        address.setStreetNo("1 Stanowczo za dlugi numer");
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifHometNumberIsTooLongValidationFails() {
        Address address = createValidAddress();
        address.setHomeNo("123456789123");
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCityIsTooLongValidationFails() {
        Address address = createValidAddress();
        address.setCity("Miasto ktorego nazwa jest stanowczo za dluga");
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCityIsNullValidationFails() {
        Address address = createValidAddress();
        address.setCity(null);
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsTooLongValidationFails() {
        Address address = createValidAddress();
        address.setZipCode("92-1234");
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsTooShortValidationFails() {
        Address address = createValidAddress();
        address.setZipCode("12");
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsNullValidationFails() {
        Address address = createValidAddress();
        address.setZipCode(null);
        
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(violations.isEmpty(), false);
    }
    
    
    public void streetNumberRegex(String streetNo, boolean validates) throws NoSuchFieldException {
        Field field = Address.class.getDeclaredField("streetNo");
        javax.validation.constraints.Pattern[] annotations = field.getAnnotationsByType(javax.validation.constraints.Pattern.class);
        assertEquals(streetNo.matches(annotations[0].regexp()), validates);
    }
    
    @Test
    public void testInvalidStreetNumber() throws NoSuchFieldException {
        streetNumberRegex("aaaaaaaa", false);
    }
    
    @Test
    public void testValidStreetNumber() throws NoSuchFieldException {
        streetNumberRegex("666", true);
        streetNumberRegex("666A", true);
    }
    
    public void zipCodeRegex(String zipCode, boolean validates) throws NoSuchFieldException {
        Field field = Address.class.getDeclaredField("zipCode");
        javax.validation.constraints.Pattern[] annotations = field.getAnnotationsByType(javax.validation.constraints.Pattern.class);
        assertEquals(zipCode.matches(annotations[0].regexp()), validates);
    }
    
    @Test
    public void testInvalidZipCode() throws NoSuchFieldException {
        zipCodeRegex("123456", false);
    }
    
    @Test
    public void testValidZipCode() throws NoSuchFieldException {
        zipCodeRegex("66-666", true);
    }
}