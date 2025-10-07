package skillup.projet_adaction_api.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.WasteType;
import skillup.projet_adaction_api.repositories.WasteTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WasteTypeService {

    private final WasteTypeRepository wasteTypeRepository;

    public WasteTypeService(WasteTypeRepository wasteTypeRepository) {
        this.wasteTypeRepository = wasteTypeRepository;
    }


    public List<WasteType> getAllWasteTypes() {
        return wasteTypeRepository.findAll();
    }
}

