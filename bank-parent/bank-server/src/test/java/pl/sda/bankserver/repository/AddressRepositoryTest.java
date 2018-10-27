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
}