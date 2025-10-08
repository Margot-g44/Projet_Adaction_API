package skillup.projet_adaction_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skillup.projet_adaction_api.entities.City;
import skillup.projet_adaction_api.services.CityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return new ResponseEntity<>(cityService.getAllCities(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.getCityById(id);

        return city.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City cityCreated = cityService.createCity(city);
        return new ResponseEntity<>(cityCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
        Optional<City> city = cityService.updateCity(id, cityDetails);

        return city.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        Optional<City> deletedCity = cityService.deleteCity(id);

        if (deletedCity.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
