package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City getById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }
}
