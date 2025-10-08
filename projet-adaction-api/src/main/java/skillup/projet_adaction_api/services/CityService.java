package skillup.projet_adaction_api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.City;
import skillup.projet_adaction_api.repositories.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Transactional
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public Optional<City> updateCity(Long id, City cityDetails) {
        Optional<City> optionalCity = cityRepository.findById(id);

        if (optionalCity.isPresent()) {
            City existingCity = optionalCity.get();
            existingCity.setName(cityDetails.getName());
            existingCity.setCoordinate(cityDetails.getCoordinate());
            City updatedCity = cityRepository.save(existingCity);
            return Optional.of(updatedCity);
        }

        return Optional.empty();
    }

    @Transactional
    public Optional<City> deleteCity(Long id) {
        Optional<City> city = cityRepository.findById(id);

        if (city.isPresent()) {
            cityRepository.delete(city.get());
        }

        return city;
    }
}

