package skillup.projet_adaction_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skillup.projet_adaction_api.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
