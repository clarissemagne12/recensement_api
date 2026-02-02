package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Agenti;
import org.example.recensement.entities.Agent;
import org.example.recensement.entities.Role;
import org.example.recensement.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service qui contient la logique métier pour la gestion des agents.
 *
 * Ce service fait le lien entre le controller et le repository.
 * Il fournit des méthodes pour créer, récupérer et rechercher des agents.
 *
 * Il utilise {@link AgentRepository} pour accéder aux données persistées.
 *
 * @author Clarisse
 * @version 1.0
 */

@Service
@Transactional
public class AgentService implements Agenti {
        @Autowired

        /** Repository injecté pour accéder aux données des cours */
        private final AgentRepository agentRepository;

        /**
         * Constructeur du service Agent.
         *
         * @param agentRepository le repository de l'entité {@link Agent}
         */

        public AgentService(AgentRepository agentRepository) {

            this.agentRepository = agentRepository;
        }

        /**
         * Récupère tous les cours enregistrés.
         *
         * @return liste de tous les agents
         */
        @Override
        public List<Agent> findAll(){
            return agentRepository.findAll();
        }
    @Override

    /**
     * Méthode publique qui peut être appelée
     * depuis n’importe quelle classe (comme ton contrôleur).
     *
     * Elle prend un identifiant id de type Long
     * pour rechercher un agent.
     */
    public Optional<Agent> findById(Long id){
        return agentRepository.findById(id);
    }

        /**
         * Enregistre un nouveau cours dans la base de données.
         *
         * @param agent l'objet cours à enregistrer
         * @return le cours enregistré avec son ID généré
         */
        @Override
        public Agent save(Agent agent){

            return agentRepository.save(agent);
        }

        /**
         * Met à jour un cours existant.
         *
             * @param agent le cours à mettre à jour
         * @return le cours mis à jour
         */
        @Override
        public Agent update(Agent agent){

            return agentRepository.save(agent);
        }

    /**
     * Cette méthode permet de supprimer un enregistrement
     * de la base de données à partir de son identifiant.
     *
     * @param id l'objet rapport à supprimer
     *
     */
        @Override
        public void deleteById(Long id){
            agentRepository.deleteById(id);
        }
    }


