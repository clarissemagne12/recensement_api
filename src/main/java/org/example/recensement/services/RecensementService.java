package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Recensementi;
import org.example.recensement.entities.Recensement;
import org.example.recensement.repositories.RecensementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecensementService implements Recensementi {

    private static final Logger logger =
            LoggerFactory.getLogger(RecensementService.class);

    private final RecensementRepository recensementRepository;

    public RecensementService(RecensementRepository recensementRepository) {
        this.recensementRepository = recensementRepository;
    }

    @Override
    public List<Recensement> findAll() {
        logger.info("Service : récupération de tous les recensements");
        List<Recensement> recensements = recensementRepository.findAll();
        logger.debug("Nombre de recensements récupérés : {}", recensements.size());
        return recensements;
    }

    @Override
    public Optional<Recensement> findById(Long id) {
        logger.info("Service : recherche du recensement id={}", id);
        return recensementRepository.findById(id)
                .map(r -> {
                    logger.debug("Recensement trouvé id={}", id);
                    return r;
                })
                .or(() -> {
                    logger.warn("Recensement non trouvé id={}", id);
                    return Optional.empty();
                });
    }

    @Override
    public Recensement save(Recensement recensement) {
        logger.info("Service : création d’un recensement");
        Recensement saved = recensementRepository.save(recensement);
        logger.info("Recensement créé avec succès id={}", saved.getId());
        return saved;
    }

    @Override
    public Recensement update(Recensement recensement) {
        logger.info("Service : mise à jour du recensement id={}", recensement.getId());
        Recensement updated = recensementRepository.save(recensement);
        logger.info("Recensement mis à jour id={}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Service : suppression du recensement id={}", id);
        recensementRepository.deleteById(id);
        logger.info("Recensement supprimé id={}", id);
    }
}