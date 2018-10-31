package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AddressRegistrationDto;
import pl.sda.bankserver.domain.Address;
import pl.sda.bankserver.repository.AddressRepository;
import pl.sda.bankserver.services.AddressService;

import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    
    private AddressRepository addressRepository;
    
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    
    @Override
    public void createAddress(AddressRegistrationDto registrationDto) {
        Address address = Address.builder()
                .streetName(registrationDto.getStreetName())
                .streetNo(registrationDto.getStreetNo())
                .homeNo(registrationDto.getHomeNo())
                .city(registrationDto.getCity())
                .zipCode(registrationDto.getZipCode())
                .build();
        addressRepository.saveAndFlush(address);
    }
    
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }
    
    @Override
    public List<Address> findAddress(Map<String, String> customQuery) {
        String streetName = "";
        String steetNo = "";
        String homeNo = "";
        String city = "";
        String zipCode = "";
        if (customQuery.get("streetName") != null) {
            streetName = customQuery.get("streetName");
        }
        if (customQuery.get("streetNo") != null) {
            steetNo = customQuery.get("streetNo");
        }
        if (customQuery.get("homeNo") != null) {
            steetNo = customQuery.get("homeNo");
        }
        if (customQuery.get("city") != null) {
            steetNo = customQuery.get("city");
        }
        if (customQuery.get("zipCode") != null) {
            steetNo = customQuery.get("zipCode");
        }
        return addressRepository.findAllByStreetNameOrAndStreetNoOrAndHomeNoOrAndCityOrAndZipCode(streetName,
                steetNo, homeNo, city, zipCode);
    }
    
    @Override
    public void updateAddress(Map<String, String> customQuery, AddressRegistrationDto registrationDto) {
        Address address = findAddress(customQuery).get(0);
        address = Address.builder()
                .streetName(registrationDto.getStreetName())
                .streetNo(registrationDto.getStreetNo())
                .homeNo(registrationDto.getHomeNo())
                .city(registrationDto.getCity())
                .zipCode(registrationDto.getZipCode())
                .build();
        addressRepository.save(address);
    }
    
    @Override
    public void deleteAddress(Map<String, String> customQuery) {
        Address address = findAddress(customQuery).get(0);
        addressRepository.delete(address);
    }
}
