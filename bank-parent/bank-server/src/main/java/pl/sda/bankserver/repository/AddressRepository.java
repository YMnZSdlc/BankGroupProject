package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findAll();

    List<Address> findAllByStreetNameOrAndStreetNoOrAndHomeNoOrAndCityOrAndZipCode(String streetName, String streetNo,
                                                                             String homeNo, String city, String
                                                                                  zipCode);
    
}
