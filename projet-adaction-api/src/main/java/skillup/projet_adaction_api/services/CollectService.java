package skillup.projet_adaction_api.services;

import jakarta.transaction.Transactional;
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

    @Transactional
    public Collect createCollect(Collect collect) {
        return collectRepository.save(collect);
    }

    @Transactional
    public Optional<Collect> updateCollect(Long id, Collect collectDetails) {
        Optional<Collect> optionalCollect = collectRepository.findById(id);
        if (optionalCollect.isPresent()) {
            Collect existingCollect = optionalCollect.get();
            existingCollect.setDate(collectDetails.getDate());
            existingCollect.setCity(collectDetails.getCity());
            existingCollect.setGlass_nb(collectDetails.getGlass_nb());
            existingCollect.setButt_nb(collectDetails.getButt_nb());
            existingCollect.setPlastic_nb(collectDetails.getPlastic_nb());
            existingCollect.setElectronics_nb(collectDetails.getElectronics_nb());
            existingCollect.setOthers_nb(collectDetails.getOthers_nb());
            existingCollect.setVolunteer(collectDetails.getVolunteer());
            Collect updatedCollect = collectRepository.save(existingCollect);
            return Optional.of(updatedCollect);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Collect> deleteCollect(Long id) {
        Optional<Collect> collect = collectRepository.findById(id);
        if (collect.isPresent()) {
            collectRepository.delete(collect.get());
        }
        return collect;
    }
}
