package skillup.projet_adaction_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final VolunteerRepository volunteerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public LoginController(VolunteerRepository volunteerRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.volunteerRepository = volunteerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerVolunteer(@RequestBody Volunteer volunteer) {
        if(volunteerRepository.findByEmail(volunteer.getEmail()) != null ) {
            return ResponseEntity.badRequest().body("Email already taken");
        }
        volunteer.setPassword(passwordEncoder.encode(volunteer.getPassword()));
        return ResponseEntity.ok(volunteerRepository.save(volunteer));
    }

    @PostMapping("/login")
}
