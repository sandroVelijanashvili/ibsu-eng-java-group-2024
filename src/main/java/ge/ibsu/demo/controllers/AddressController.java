package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.services.AddressService;
import ge.ibsu.demo.services.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;
    private final CityService cityService;

    public AddressController(AddressService addressService, CityService cityService) {
        this.addressService = addressService;
        this.cityService = cityService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Address getById(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Address addAddress(@RequestBody Address address) {

        City city = address.getCity();
        if (city != null && cityService.getById(city.getId()) == null) {
            cityService.addCity(city);
        }

        return addressService.addAddress(address);
    }
}
