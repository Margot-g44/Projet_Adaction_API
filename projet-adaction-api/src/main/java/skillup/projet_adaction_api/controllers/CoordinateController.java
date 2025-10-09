package skillup.projet_adaction_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skillup.projet_adaction_api.entities.Coordinate;
import skillup.projet_adaction_api.services.CoordinateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coordinates")
public class CoordinateController {
    private final CoordinateService coordinateService;

    public CoordinateController(CoordinateService coordinateService){
        this.coordinateService = coordinateService;
    }

    @GetMapping
    public ResponseEntity<List<Coordinate>> getAllCoordinates() {
        return new ResponseEntity<>(coordinateService.getAllCoordinates(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordinate> getCoordinateById(@PathVariable Long id){

        Optional<Coordinate> coordinate = coordinateService.getCoordinateById(id);

        if(coordinate.isPresent()){
            return new ResponseEntity<>(coordinate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
