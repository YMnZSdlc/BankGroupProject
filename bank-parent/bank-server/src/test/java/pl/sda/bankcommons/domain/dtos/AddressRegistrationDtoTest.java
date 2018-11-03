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

public class AddressRegistrationDtoTest {
    private Validator validator;
    
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    private AddressRegistrationDto createValidAddressRegistrationDto() {
        AddressRegistrationDto address = new AddressRegistrationDto();
        address.setStreetName("Nigdzie");
        address.setStreetNo("666Z");
        address.setHomeNo("666");
        address.setCity("Zgierz");
        address.setZipCode("00-666");
        address.setCustomerAddressIds(null);
        address.setDepartmentAddressIds(null);
        address.setWorkerAddressIds(null);
        
        return address;
    }
    
    private AddressRegistrationDto createEmptyAddressRegistrationDto() {
        AddressRegistrationDto address = new AddressRegistrationDto();
        return address;
    }
    
    @Test
    public void ifAddressRegistrationDtoIsValid() {
        //given
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createEmptyAddressRegistrationDto();
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setStreetName(null);
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setStreetName("Ulica ktorej nazwa jest stanowczo za dluga");
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setStreetNo(null);
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setStreetNo("1 Stanowczo za dlugi numer");
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setHomeNo("123456789123");
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setCity("Miasto ktorego nazwa jest stanowczo za dluga");
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setCity(null);
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setZipCode("92-1234");
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setZipCode("12");
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
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
        AddressRegistrationDto address = createValidAddressRegistrationDto();
        address.setZipCode(null);
        //when
        Set<ConstraintViolation<AddressRegistrationDto>> violations = validator.validate(address);
        for (ConstraintViolation<AddressRegistrationDto> violation : violations) {
            System.out.println(violation.getRootBeanClass() + " Validation: "
                    + violation.getPropertyPath() + " "
                    + violation.getMessage());
        }
        //then
        Assert.assertEquals(violations.isEmpty(), false);
    }
    
    private Pattern[] getPatterns(String model) throws NoSuchFieldException {
        Field field = AddressRegistrationDto.class.getDeclaredField(model);
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