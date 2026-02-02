package org.example.recensement.controllers;

import org.example.recensement.entities.Agent;
import org.example.recensement.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des agents.
 *
 * Il expose les endpoints HTTP permettant de :
 * - créer un agent
 * - récupérer tous les agents
 * - récupérer un agent par son identifiant
 * - modifier un agent
 * - supprimer un agent
 *
 * @author Clarisse
 * @version 1.0
 */

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    private final AgentService agentService;

    /**
     * Constructeur avec injection du service Agent.
     *
     * @param agentService service de gestion des agents
     */
    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    /**
     * Récupérer tous les agents.
     *
     * @return liste des agents
     */
    @GetMapping
    public List<Agent> findAll() {
        return agentService.findAll();
    }

    /**
     * Récupérer un agent par son identifiant.
     *
     * @param id identifiant de l'agent
     * @return agent trouvé
     */
        @GetMapping("/{id}")
    public Optional<Agent> findById(@PathVariable long id){

        return agentService.findById(id);
    }

    /**
     * Créer un nouvel agent.
     *
     * @param agent agent à enregistrer
     * @return agent créé
     */
    @PostMapping
    public Agent save(@RequestBody Agent agent){

            return agentService.save(agent);
    }

    /**
     * Mettre à jour un agent existant.
     *
     * @param @id identifiant de l'agent
     * @param agent agent modifié
     * @return agent mis à jour ou 404
     */
    @PutMapping("/{id}")
    public Agent update(@RequestBody Agent agent){

        return agentService.save(agent);
    }

    /**
     * Supprimer un agent par son identifiant.
     *
     * @param id identifiant de l'agent
     * @return message de confirmation
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        agentService.deleteById(id);
    }
}

