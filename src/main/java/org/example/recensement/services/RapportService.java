package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Rapporti;
import org.example.recensement.entities.Rapport;
import org.example.recensement.repositories.RapportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RapportService implements Rapporti {

    private static final Logger logger =
            LoggerFactory.getLogger(RapportService.class);

    private final RapportRepository rapportRepository;

    public RapportService(RapportRepository rapportRepository) {
        this.rapportRepository = rapportRepository;
    }

    @Override
    public List<Rapport> findAll() {
        logger.info("Service : récupération de tous les rapports");
        List<Rapport> rapports = rapportRepository.findAll();
        logger.debug("Nombre de rapports récupérés : {}", rapports.size());
        return rapports;
    }

    @Override
    public Optional<Rapport> findById(Long id) {
        logger.info("Service : recherche du rapport id={}", id);
        return rapportRepository.findById(id)
                .map(r -> {
                    logger.debug("Rapport trouvé id={}", id);
                    return r;
                })
                .or(() -> {
                    logger.warn("Rapport non trouvé id={}", id);
                    return Optional.empty();
                });
    }

    @Override
    public Rapport save(Rapport rapport) {
        logger.info("Service : création d’un rapport");
        Rapport saved = rapportRepository.save(rapport);
        logger.info("Rapport créé id={}", saved.getId());
        return saved;
    }

    @Override
    public Rapport update(Rapport rapport) {
        logger.info("Service : mise à jour du rapport id={}", rapport.getId());
        Rapport updated = rapportRepository.save(rapport);
        logger.info("Rapport mis à jour id={}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Service : suppression du rapport id={}", id);
        rapportRepository.deleteById(id);
        logger.info("Rapport supprimé id={}", id);
    }
}