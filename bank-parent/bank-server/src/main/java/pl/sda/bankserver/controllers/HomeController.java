package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.bankserver.domain.Address;
import pl.sda.bankserver.services.AddressService;

import java.util.List;

@RestController
public class HomeController {

    private AddressService addressService;

    @Autowired
    public HomeController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddresses")
    public List<Address> findAllAddresses() {
        return addressService.findAllBy();
    }

    @GetMapping("/getAddress")
    public List<Address> findAllBy(@RequestParam(name = "id", required = false) Integer id,
                                   @RequestParam(name = "streetName", required = false) String streetName) throws Exception {
        if (id != null) {
            return addressService.findAllById(id);
        } else if (streetName != null) {
            return addressService.findAllByStreetName(streetName);
        } else {
            throw new Exception("Missing request param.");
        }
    }
}
