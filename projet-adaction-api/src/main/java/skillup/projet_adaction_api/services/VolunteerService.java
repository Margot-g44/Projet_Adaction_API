package skillup.projet_adaction_api.services;

import jakarta.transaction.Transactional;
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
            existingVolunteer.setEmail(volunteerDetails.getEmail());
            existingVolunteer.setPassword(volunteerDetails.getPassword());
            existingVolunteer.setLocation(volunteerDetails.getLocation());
            existingVolunteer.setUpdated_at(volunteerDetails.getUpdated_at());
            existingVolunteer.setTotal_points(volunteerDetails.getTotal_points());
            existingVolunteer.setDonation_points(volunteerDetails.getDonation_points());
            Volunteer updatedVolunteer = volunteerRepository.save(existingVolunteer);
            return Optional.of(updatedVolunteer);
        }

        return Optional.empty();
    }

    @Transactional
    public Optional<Volunteer> deleteVolunteer(Long id) {
        Optional<Volunteer> volunteer = volunteerRepository.findById(id);

        if (volunteer.isPresent()) {
            volunteerRepository.delete(volunteer.get());
        }

        return volunteer;
    }
}
