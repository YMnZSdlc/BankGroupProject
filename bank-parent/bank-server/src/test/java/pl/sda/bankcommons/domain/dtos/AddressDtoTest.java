package pl.sda.bankcommons.domain.dtos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;
import java.util.Set;

public class AddressDtoTest {
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private AddressDto createValidAddressRegistrationDto() {
        AddressDto address = new AddressDto();
        address.setStreetName("Nigdzie");
        address.setStreetNo("666Z");
        address.setHomeNo("666");
        address.setCity("Zgierz");
        address.setZipCode("00-666");
        address.setCustomersAddresses(null);
        address.setDepartmentAddresses(null);
        address.setWorkerAddresses(null);
        
        return address;
    }
    
    private AddressDto createEmptyAddressRegistrationDto() {
        AddressDto address = new AddressDto();
        return address;
    }
    
    @Test
    public void ifAddressRegistrationDtoIsValid() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), true);
    }
    
    @Test
    public void ifAddressRegistrationDtoIsEmpty() {
        //given
        AddressDto address = createEmptyAddressRegistrationDto();
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNameIsNullValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setStreetName(null);
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNameIsTooLongValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setStreetName("Ulica ktorej nazwa jest stanowczo za dluga");
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNumberIsNullValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setStreetNo(null);
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifStreetNumberIsTooLongValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setStreetNo("1 Stanowczo za dlugi numer");
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifHometNumberIsTooLongValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setHomeNo("123456789123");
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCityIsTooLongValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setCity("Miasto ktorego nazwa jest stanowczo za dluga");
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifCityIsNullValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setCity(null);
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsTooLongValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setZipCode("92-1234");
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsTooShortValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setZipCode("12");
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    @Test
    public void ifZipCodeIsNullValidationFails() {
        //given
        AddressDto address = createValidAddressRegistrationDto();
        address.setZipCode(null);
        //when
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    private Pattern[] getPatterns(String model) throws NoSuchFieldException {
        Field field = AddressDto.class.getDeclaredField(model);
        return field.getAnnotationsByType(Pattern.class);
    }
    
    @Test
    public void testInvalidStreetNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("streetNo");
        //then
        Assert.assertEquals("aaaaaaaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidStreetNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("streetNo");
        //then
        Assert.assertEquals("666".matches(annotations[0].regexp()), true);
        Assert.assertEquals("666A".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidHomeNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("homeNo");
        //then
        Assert.assertEquals("666A".matches(annotations[0].regexp()), false);
        Assert.assertEquals("aaa".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidHomeNumber() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("homeNo");
        //then
        Assert.assertEquals("666".matches(annotations[0].regexp()), true);
    }
    
    @Test
    public void testInvalidZipCode() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("zipCode");
        //then
        Assert.assertEquals("123456".matches(annotations[0].regexp()), false);
    }
    
    @Test
    public void testValidZipCode() throws NoSuchFieldException {
        //when
        Pattern[] annotations = getPatterns("zipCode");
        //then
        Assert.assertEquals("66-666".matches(annotations[0].regexp()), true);
    }
}