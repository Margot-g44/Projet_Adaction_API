package skillup.projet_adaction_api.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;

import java.util.Collections;

@Service

public class VolunteerDetailsService implements UserDetailsService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerDetailsService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 1. Récupérer l'utilisateur à partir de son email en utilisant le repository
        Volunteer volunteer = volunteerRepository.findByEmail(email);

        // 2. Vérifier si l'utilisateur a bien été trouvé
        if (volunteer == null) {
            // 3. Si l'utilisateur n'est pas trouvé, lancer une exception UsernameNotFoundException
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // 4. Créer un objet CustomUserDetails à partir de l'utilisateur trouvé
        // Ici, nous utilisons uniquement l'email et le mot de passe de l'utilisateur
        return new CustomVolunteerDetails(
                volunteer.getEmail(),
                volunteer.getPassword()
        );
    }
}