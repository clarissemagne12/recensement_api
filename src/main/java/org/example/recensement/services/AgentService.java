package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Agenti;
import org.example.recensement.entities.Agent;
import org.example.recensement.repositories.AgentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgentService implements Agenti {

    private static final Logger logger =
            LoggerFactory.getLogger(AgentService.class);

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public List<Agent> findAll() {
        logger.info("Service : récupération de tous les agents");
        List<Agent> agents = agentRepository.findAll();
        logger.debug("Nombre d'agents récupérés : {}", agents.size());
        return agents;
    }

    @Override
    public Optional<Agent> findById(Long id) {
        logger.info("Service : recherche de l'agent id={}", id);
        return agentRepository.findById(id)
                .map(a -> {
                    logger.debug("Agent trouvé id={}", id);
                    return a;
                })
                .or(() -> {
                    logger.warn("Agent non trouvé id={}", id);
                    return Optional.empty();
                });
    }

    @Override
    public Agent save(Agent agent) {
        logger.info("Service : création d’un agent");
        Agent saved = agentRepository.save(agent);
        logger.info("Agent créé id={}", saved.getId());
        return saved;
    }

    @Override
    public Agent update(Agent agent) {
        logger.info("Service : mise à jour de l'agent id={}", agent.getId());
        Agent updated = agentRepository.save(agent);
        logger.info("Agent mis à jour id={}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Service : suppression de l'agent id={}", id);
        agentRepository.deleteById(id);
        logger.info("Agent supprimé id={}", id);
    }
}