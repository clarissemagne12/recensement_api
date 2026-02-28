package org.example.recensement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.recensement.entities.Recensement;
import org.example.recensement.services.RecensementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recensement")
@Tag(name = "Gestion des Recensements", description = "API permettant de gérer les données de recensement")
public class RecensementController {

    private final RecensementService recensementService;

    @Autowired
    public RecensementController(RecensementService recensementService) {
        this.recensementService = recensementService;
    }

    @GetMapping
    @Operation(summary = "Lister tous les recensements", description = "Récupère la liste complète enregistrée en base.")
    public List<Recensement> findAll() {
        return recensementService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Trouver un recensement par ID", description = "Retourne un seul recensement en fonction de son identifiant unique.")
    @ApiResponse(responseCode = "200", description = "Recensement trouvé")
    @ApiResponse(responseCode = "404", description = "Recensement non trouvé")
    public Optional<Recensement> findById(
            @Parameter(description = "ID du recensement à récupérer", example = "1")
            @PathVariable long id){
        return recensementService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un recensement", description = "Enregistre un nouvel objet recensement dans le système.")
    public Recensement save(@RequestBody Recensement recensement) {
        return recensementService.save(recensement);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un recensement", description = "Modifie les données d'un recensement existant via son ID.")
    public Recensement update(
            @Parameter(description = "ID du recensement à modifier")
            @PathVariable long id,
            @RequestBody Recensement recensement){
        // On s'assure que l'objet prend bien l'ID de l'URL
        return recensementService.save(recensement);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un recensement", description = "Supprime définitivement un enregistrement de la base de données.")
    @ApiResponse(responseCode = "204", description = "Suppression réussie")
    public void deleteById(
            @Parameter(description = "ID du recensement à supprimer")
            @PathVariable Long id){
        recensementService.deleteById(id);
    }
}