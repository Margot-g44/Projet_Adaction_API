package skillup.projet_adaction_api.services;

import org.springframework.stereotype.Service;
import skillup.projet_adaction_api.entities.Collect;
import skillup.projet_adaction_api.repositories.CollectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CollectService {
    private final CollectRepository collectRepository;

    public CollectService(CollectRepository collectRepository){
        this.collectRepository = collectRepository;
    }

    public List<Collect> getAllCollects() {
        return collectRepository.findAll();
    }

    public Optional<Collect> getCollectById(Long id) {
        return collectRepository.findById(id);
    }
}
