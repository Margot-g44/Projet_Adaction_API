package skillup.projet_adaction_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skillup.projet_adaction_api.entities.Association;
import skillup.projet_adaction_api.services.AssociationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assocations")
public class AssociationController {

    private final AssociationService associationService;

    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }

    @GetMapping
    public ResponseEntity<List<Association>> getAllAssociations(){
     return new ResponseEntity<>(associationService.getAllAssociations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Association> getAssociationById(@PathVariable Long id){

        Optional<Association> association = associationService.getAssociationById(id);

        if(association.isPresent()){
            return new ResponseEntity<>(association.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
