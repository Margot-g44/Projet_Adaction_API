package skillup.projet_adaction_api.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.CustomVolunteerDetails;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;

@Service

public class VolunteerDetailsService implements UserDetailsService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerDetailsService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Volunteer volunteer = volunteerRepository.findByEmail(email);

        if (volunteer == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new CustomVolunteerDetails(
                volunteer.getEmail(),
                volunteer.getPassword()
        );
    }
}