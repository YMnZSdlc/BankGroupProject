package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.sda.bankserver.domain.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findAll();

    List<Address> findAllById(Integer id);

    List<Address> findAllByStreetName(String streetName);
}
