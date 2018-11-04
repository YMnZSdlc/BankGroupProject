package pl.sda.bankserver.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.bankserver.domain.Address;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        //assertEquals(result.size(), addressCount);
    }

    @Test
    public void findAllById() {
        //given
        List<Integer> id = new ArrayList<>();
        id.add(1);
        // when
        List<Address> result = addressRepository.findAllById(id);
        //then
//        Address address = result.get(0);
        //TODO assertions need to be fixed
        //TESTS should be separated
//        assertEquals(address.getId(), id.get(0));
//        assertEquals(address.getStreetName(), "Corben");
//        assertEquals(address.getStreetNo(), "29");
//        assertEquals(address.getHomeNo(), "61");
//        assertEquals(address.getCity(), "Sonquil");
//        assertEquals(address.getZipCode(), "92-210");
    }

    @Test
    public void findAllByStreetName() {
        //given
        String streetName = "Arizona";
        int id = 5;
        //when
        List<Address> result = addressRepository.findAllByStreetName(streetName);
        //then
        //TODO assertion
    }

    @Test
    public void save() {
        //given
        List<Integer> id = new ArrayList<>();
        id.add(1);

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
        address = addressRepository.findAllById(id).get(0);
        String city = address.getCity();
        id = new ArrayList<>();
        id.add(address.getId());
        address.setCity("ABCDEFG");
        addressRepository.saveAndFlush(address);
        // when
        address = addressRepository.findAllById(id).get(0);
        // then
        //assertEquals(address.getCity(), city);
        //TODO fix assertion

    }

}