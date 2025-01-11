package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.services.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<City> getAll() {
        return cityService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public City getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }
}
