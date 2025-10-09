package skillup.projet_adaction_api.services;

import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.Coordinate;
import skillup.projet_adaction_api.repositories.CoordinateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinateService {
    private final CoordinateRepository coordinateRepository;

    public CoordinateService(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    public List<Coordinate> getAllCoordinates() {
        return coordinateRepository.findAll();
    }

    public Optional<Coordinate> getCoordinateById(Long id) {
        return coordinateRepository.findById(id);
    }
}
