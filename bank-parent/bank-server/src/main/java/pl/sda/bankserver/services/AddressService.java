package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.AddressDto;
import pl.sda.bankserver.domain.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {
    
    void createAddress(AddressDto registrationDto);
    
    List<Address> findAll();
    
    List<Address> findAddress(Map<String, String> customQuery);
    
    void updateAddress(Map<String, String> customQuery, AddressDto registrationDto);
    
    void deleteAddress(Map<String, String> customQuery);
}
