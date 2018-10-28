package pl.sda.bankserver.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.bankserver.domain.Address;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void findAll() {
        //given
        int addressCount = 13;
        //when
        List<Address> result = addressRepository.findAll();
        //then
        assertEquals(result.size(), addressCount);
    }

    @Test
    public void findAllById() {
        //given
        Integer id = 1;
        // when
        List<Address> result = addressRepository.findAllById(id);
        //then
        assertEquals(result.get(0).getId(), id);
        assertEquals(result.get(0).getStreetName(), "Corben");
        assertEquals(result.get(0).getStreetNo(), "29");
        assertEquals(result.get(0).getHomeNo(), "61");
        assertEquals(result.get(0).getCity(), "Sonquil");
        assertEquals(result.get(0).getZipCode(), "92-210");
    }

    @Test
    public void findAllByStreetName() {
        //given
        String streetName = "Arizona";
        int id = 5;
        //when
        List<Address> result = addressRepository.findAllByStreetName(streetName);
        //then
//        assertEquals(result.get(0).getId(), 5);
    }


    @Test
    public void save() {

        // ---------- CREATE
        // given
        Address address = new Address();
        address.setId(1);
        address.setStreetName("Abcdefghij");
        address.setStreetNo("77");
        address.setHomeNo("4");
        address.setCity("Warszawa");
        address.setZipCode("00-117");

        addressRepository.saveAndFlush(address);
        // when
        List<Address> result = addressRepository.findAllByStreetName("Abcdefghij");
        // then
        assertEquals(result.get(0).getStreetName(), address.getStreetName());

        // ---------- UPDATE
        // given
        address = addressRepository.findAllById(1).get(0);
        String city = address.getCity();
        Integer id = address.getId();
        address.setCity("ABCDEFG");
        addressRepository.saveAndFlush(address);
        // when
        address = addressRepository.findAllById(id).get(0);
        // then
        assertEquals(address.getCity(), city);

    }
}