package skillup.projet_adaction_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import skillup.projet_adaction_api.config.JwtUtil;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final VolunteerRepository volunteerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LoginController(VolunteerRepository volunteerRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.volunteerRepository = volunteerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
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
    public ResponseEntity<?> loginVolunteer(@RequestBody Volunteer volunteer) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(volunteer.getEmail(), volunteer.getPassword()));
            String token = jwtUtil.generateToken(volunteer.getEmail());
            return ResponseEntity.ok().body(Map.of("token", token));
        } catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
