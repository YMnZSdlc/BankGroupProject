package pl.sda.bankserver.domain;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
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
        //given
        Address address = createValidAddress();
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifStreetNameIsNullValidationFails() {
        //given
        Address address = createValidAddress();
        address.setStreetName(null);
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNameIsTooLongValidationFails() {
        //given
        Address address = createValidAddress();
        address.setStreetName("Ulica ktorej nazwa jest stanowczo za dluga");
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNumberIsNullValidationFails() {
        //given
        Address address = createValidAddress();
        address.setStreetNo(null);
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNumberIsTooLongValidationFails() {
        //given
        Address address = createValidAddress();
        address.setStreetNo("1 Stanowczo za dlugi numer");
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifHometNumberIsTooLongValidationFails() {
        //given
        Address address = createValidAddress();
        address.setHomeNo("123456789123");
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCityIsTooLongValidationFails() {
        //given
        Address address = createValidAddress();
        address.setCity("Miasto ktorego nazwa jest stanowczo za dluga");
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCityIsNullValidationFails() {
        //given
        Address address = createValidAddress();
        address.setCity(null);
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsTooLongValidationFails() {
        //given
        Address address = createValidAddress();
        address.setZipCode("92-1234");
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsTooShortValidationFails() {
        //given
        Address address = createValidAddress();
        address.setZipCode("12");
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsNullValidationFails() {
        //given
        Address address = createValidAddress();
        address.setZipCode(null);
        //when
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        //then
        assertEquals(violations.isEmpty(), false);
    }

    private Pattern[] getPatterns(String model) throws NoSuchFieldException {
        Field field = Address.class.getDeclaredField(model);
        return field.getAnnotationsByType(Pattern.class);
    }

    @Test
    public void testInvalidStreetNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("streetNo");
        //then
        assertEquals("aaaaaaaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidStreetNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("streetNo");
        //then
        assertEquals("666".matches(annotations[0].regexp()), true);
        assertEquals("666A".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidZipCode() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("zipCode");
        //then
        assertEquals("123456".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidZipCode() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("zipCode");
        //then
        assertEquals("66-666".matches(annotations[0].regexp()), true);
    }


}