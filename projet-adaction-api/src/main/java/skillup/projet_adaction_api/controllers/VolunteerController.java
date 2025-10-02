package skillup.projet_adaction_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")

public class VolunteerController {

    final VolunteerRepository volunteerRepository;

    public VolunteerController(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

@GetMapping
    public ResponseEntity<List<Volunteer>> getAllVolunteers(){
        return new ResponseEntity<>(volunteerRepository.findAll(), HttpStatus.OK);
    }
}
