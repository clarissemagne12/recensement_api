package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Chefbureaui;
import org.example.recensement.entities.Chefbureau;
import org.example.recensement.repositories.ChefbureauRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChefbureauService implements Chefbureaui {

    private static final Logger logger =
            LoggerFactory.getLogger(ChefbureauService.class);

    private final ChefbureauRepository chefbureauRepository;

    public ChefbureauService(ChefbureauRepository chefbureauRepository) {
        this.chefbureauRepository = chefbureauRepository;
    }

    @Override
    public List<Chefbureau> findAll() {
        logger.info("Service : récupération de tous les chefbureaux");
        List<Chefbureau> list = chefbureauRepository.findAll();
        logger.debug("Nombre de chefbureaux récupérés : {}", list.size());
        return list;
    }

    @Override
    public Optional<Chefbureau> findById(Long id) {
        logger.info("Service : recherche du chefbureau id={}", id);
        return chefbureauRepository.findById(id)
                .map(c -> {
                    logger.debug("Chefbureau trouvé id={}", id);
                    return c;
                })
                .or(() -> {
                    logger.warn("Chefbureau non trouvé id={}", id);
                    return Optional.empty();
                });
    }

    @Override
    public Chefbureau save(Chefbureau chefbureau) {
        logger.info("Service : création d’un chefbureau");
        Chefbureau saved = chefbureauRepository.save(chefbureau);
        logger.info("Chefbureau créé id={}", saved.getId());
        return saved;
    }

    @Override
    public Chefbureau update(Chefbureau chefbureau) {
        logger.info("Service : mise à jour du chefbureau id={}", chefbureau.getId());
        Chefbureau updated = chefbureauRepository.save(chefbureau);
        logger.info("Chefbureau mis à jour id={}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Service : suppression du chefbureau id={}", id);
        chefbureauRepository.deleteById(id);
        logger.info("Chefbureau supprimé id={}", id);
    }
}