package skillup.projet_adaction_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skillup.projet_adaction_api.entities.Volunteer;
import skillup.projet_adaction_api.repositories.VolunteerRepository;
import skillup.projet_adaction_api.services.VolunteerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public ResponseEntity<List<Volunteer>> getAllVolunteers(){
        return new ResponseEntity<>(volunteerService.getAllVolunteers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Volunteer> getVolunteerById(@PathVariable Long id){
        
        Optional<Volunteer> volunteer = volunteerService.getVolunteerById(id);

        if(volunteer.isPresent()) {
            return new ResponseEntity<>(volunteer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Volunteer> createVolunteer(@RequestBody Volunteer volunteer){
        Volunteer volunteerCreated = volunteerService.createVolunteer(volunteer);
        return new ResponseEntity<>(volunteerCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(@PathVariable Long id, @RequestBody Volunteer volunteerDetails){
        Optional<Volunteer> volunteer = volunteerService.updateVolunteer(id, volunteerDetails);

        if(volunteer.isPresent()){
            return new ResponseEntity<>(volunteer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable Long id) {
        Optional<Volunteer> deletedVolunteer = volunteerService.deleteVolunteer(id);

        if (deletedVolunteer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
