package skillup.projet_adaction_api.services;

import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.Association;
import skillup.projet_adaction_api.repositories.AssociationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationService {
    private final AssociationRepository associationRepository;

    public AssociationService(AssociationRepository associationRepository){
        this.associationRepository = associationRepository;
    }

    public List<Association> getAllAssociations() {
        return associationRepository.findAll();
    }

    public Optional<Association> getAssociationById(Long id) {
        return associationRepository.findById(id);
    }
}
