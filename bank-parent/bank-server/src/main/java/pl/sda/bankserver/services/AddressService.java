package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AddressRegistrationDto;
import pl.sda.bankserver.domain.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {
    
    void createAddress(AddressRegistrationDto registrationDto);
    
    List<Address> findAll();
    
    List<Address> findAddress(Map<String, String> customQuery);
    
    void updateAddress(Map<String, String> customQuery, AddressRegistrationDto registrationDto);
    
    void deleteAddress(Map<String, String> customQuery);
}
