package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Personnei;
import org.example.recensement.entities.Personne;
import org.example.recensement.repositories.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonneService implements Personnei {

    private static final Logger logger =
            LoggerFactory.getLogger(PersonneService.class);

    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public List<Personne> findAll() {
        logger.info("Service : récupération de toutes les personnes");
        List<Personne> personnes = personneRepository.findAll();
        logger.debug("Nombre de personnes récupérées : {}", personnes.size());
        return personnes;
    }

    @Override
    public Optional<Personne> findById(Long id) {
        logger.info("Service : recherche de la personne id={}", id);
        return personneRepository.findById(id)
                .map(p -> {
                    logger.debug("Personne trouvée id={}", id);
                    return p;
                })
                .or(() -> {
                    logger.warn("Personne non trouvée id={}", id);
                    return Optional.empty();
                });
    }

    @Override
    public Personne save(Personne personne) {
        logger.info("Service : création d’une personne");
        Personne saved = personneRepository.save(personne);
        logger.info("Personne créée id={}", saved.getId());
        return saved;
    }

    @Override
    public Personne update(Personne personne) {
        logger.info("Service : mise à jour de la personne id={}", personne.getId());
        Personne updated = personneRepository.save(personne);
        logger.info("Personne mise à jour id={}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Service : suppression de la personne id={}", id);
        personneRepository.deleteById(id);
        logger.info("Personne supprimée id={}", id);
    }
}