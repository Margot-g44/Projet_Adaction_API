package skillup.projet_adaction_api.services;

import jakarta.transaction.Transactional;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public Optional<Volunteer> getVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }

    @Transactional
    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @Transactional
    public Optional<Volunteer> updateVolunteer(Long id, Volunteer volunteerDetails) {
        Optional<Volunteer> optionalVolunteer = volunteerRepository.findById(id);

        if (optionalVolunteer.isPresent()) {
            Volunteer existingVolunteer = optionalVolunteer.get();
            existingVolunteer.setFirstname(volunteerDetails.getFirstname());
            existingVolunteer.setLastname(volunteerDetails.getLastname());
            existingVolunteer.setLocation(volunteerDetails.getLocation());
            Volunteer updatedVolunteer = volunteerRepository.save(existingVolunteer);
            return Optional.of(updatedVolunteer);
        }

        return Optional.empty();
    }
}
