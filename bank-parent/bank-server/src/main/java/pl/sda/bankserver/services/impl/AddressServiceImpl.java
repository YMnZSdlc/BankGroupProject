package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.AddressDto;
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
    public void createAddress(AddressDto registrationDto) {
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
        String streetName = customQuery.get("streetName");
        String streetNo = customQuery.get("streetNo");
        String homeNo = customQuery.get("homeNo");
        String city = customQuery.get("city");
        String zipCode = customQuery.get("zipCode");
        return addressRepository.findByStreetNameOrStreetNoOrHomeNoOrCityOrZipCode(
                streetName, streetNo, homeNo, city, zipCode);
    }

    @Override
    public void updateAddress(Map<String, String> customQuery, AddressDto registrationDto) {
        //TODO fix
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
