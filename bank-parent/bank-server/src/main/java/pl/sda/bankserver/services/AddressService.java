package pl.sda.bankserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankserver.domain.Address;
import pl.sda.bankserver.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // ---------- CREATE
    public void createAddress(Address address) {
        addressRepository.saveAndFlush(address);
    }

    // ----------  READ
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public List<Address> findAllById(Integer id) {
        return addressRepository.findAllById(id);
    }

    public List<Address> findAllByStreetName(String streetName) {
        return addressRepository.findAllByStreetName(streetName);
    }

    // ----------  UPDATE
    public void updateAddress(Address address){
        addressRepository.saveAndFlush(address);
    }

    // ---------- DELETE
    public void removeAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
