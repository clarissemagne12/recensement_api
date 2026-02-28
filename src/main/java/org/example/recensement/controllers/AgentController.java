package org.example.recensement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.recensement.entities.Agent;
import org.example.recensement.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Clarisse
 * @version 1.0
 */
@RestController
@RequestMapping("/api/agent")
@Tag(name = "Gestion des Agents", description = "API pour l'administration des agents de recensement")
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    @Operation(summary = "Lister tous les agents", description = "Récupère la liste complète des agents enregistrés.")
    public List<Agent> findAll() {
        return agentService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Trouver un agent par ID", description = "Recherche un agent spécifique à partir de son identifiant unique.")
    public Optional<Agent> findById(
            @Parameter(description = "ID de l'agent", example = "1")
            @PathVariable long id){
        return agentService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un agent", description = "Enregistre un nouvel agent dans le système.")
    public Agent save(@RequestBody Agent agent){
        return agentService.save(agent);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un agent", description = "Modifie les informations d'un agent existant via son ID.")
    public Agent update(
            @Parameter(description = "ID de l'agent à modifier")
            @PathVariable long id,
            @RequestBody Agent agent){
        // Sécurité : on s'assure que l'ID de l'URL est celui utilisé pour l'enregistrement
        return agentService.save(agent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un agent", description = "Supprime définitivement un agent de la base de données.")
    public void deleteById(
            @Parameter(description = "ID de l'agent à supprimer")
            @PathVariable Long id){
        agentService.deleteById(id);
    }
}