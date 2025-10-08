package skillup.projet_adaction_api.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skillup.projet_adaction_api.entities.Collect;
import skillup.projet_adaction_api.services.CollectService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collects")
public class CollectController {
    private final CollectService collectService;

    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    @GetMapping
    public ResponseEntity<List<Collect>> getAllCollects() {
        return new ResponseEntity<>(collectService.getAllCollects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collect> getCollectById(@PathVariable Long id) {
        Optional<Collect> collect = collectService.getCollectById(id);
        if (collect.isPresent()) {
            return new ResponseEntity<>(collect.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Collect> createCollect(@RequestBody Collect collect) {
        Collect createdCollect = collectService.createCollect(collect);
        return new ResponseEntity<>(createdCollect, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collect> updateCollect(@PathVariable Long id, @RequestBody Collect collectDetails) {
        Optional<Collect> updatedCollect = collectService.updateCollect(id, collectDetails);
        if (updatedCollect.isPresent()) {
            return new ResponseEntity<>(updatedCollect.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollect(@PathVariable Long id) {
        Optional<Collect> deletedCollect = collectService.deleteCollect(id);
        if (deletedCollect.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
