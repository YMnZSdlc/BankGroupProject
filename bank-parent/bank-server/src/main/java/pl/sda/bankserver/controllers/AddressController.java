package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.AddressDto;
import pl.sda.bankserver.domain.Address;
import pl.sda.bankserver.services.AddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/server/address/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@RequestBody @Valid AddressDto registrationDto) {
        addressService.createAddress(registrationDto);
    }
    
    @GetMapping("/server/address/all")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/server/address/find")
    public List<Address> findAddress(@RequestParam Map<String, String> customQuery){
        return addressService.findAddress(customQuery);
    }
    
    @PutMapping("/server/address/update")
    public void updateAddress(@RequestParam Map<String, String> customQuery, @RequestBody @Valid AddressDto
            registrationDto) {
        addressService.updateAddress(customQuery, registrationDto);
    }
    
    @DeleteMapping("/server/address/delete")
    public void deleteAddress(@RequestParam Map<String, String> customQuery){
        addressService.deleteAddress(customQuery);
    }
}
