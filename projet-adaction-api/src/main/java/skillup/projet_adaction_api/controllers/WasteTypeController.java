package skillup.projet_adaction_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skillup.projet_adaction_api.entities.WasteType;
import skillup.projet_adaction_api.services.WasteTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/waste_type")
public class WasteTypeController {

    private final WasteTypeService wasteTypeService;

    public WasteTypeController(WasteTypeService wasteTypeService) {
        this.wasteTypeService = wasteTypeService;
    }

    @GetMapping
    public ResponseEntity<List<WasteType>> getAllVolunteers() {
        return new ResponseEntity<>(wasteTypeService.getAllWasteTypes(), HttpStatus.OK);
    }

}
