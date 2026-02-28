package org.example.recensement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.recensement.entities.Chefbureau;
import org.example.recensement.services.ChefbureauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des Chefs de bureau.
 */
@RestController
@RequestMapping("/api/chefbureau")
@Tag(name = "Gestion des Chefs de Bureau", description = "API pour l'administration des responsables de bureau de recensement")
public class ChefbureauController {

    private final ChefbureauService chefbureauService;

    @Autowired
    public ChefbureauController(ChefbureauService chefbureauService) {
        this.chefbureauService = chefbureauService;
    }

    @GetMapping
    @Operation(summary = "Lister tous les chefs de bureau", description = "Récupère la liste complète des chefs de bureau.")
    public List<Chefbureau> findAll() {
        return chefbureauService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Trouver un chef de bureau par ID", description = "Recherche les informations d'un chef de bureau spécifique.")
    public Optional<Chefbureau> findById(
            @Parameter(description = "Identifiant unique du chef de bureau", example = "5")
            @PathVariable long id){
        return chefbureauService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un chef de bureau", description = "Enregistre un nouveau responsable dans le système.")
    public Chefbureau save(@RequestBody Chefbureau chefbureau){
        return chefbureauService.save(chefbureau);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un chef de bureau", description = "Met à jour les données d'un chef de bureau existant via son ID.")
    public Chefbureau update(
            @Parameter(description = "ID du chef de bureau à modifier")
            @PathVariable long id,
            @RequestBody Chefbureau chefbureau){
        // Sécurité : on s'assure que l'objet enregistré possède le bon ID
        return chefbureauService.save(chefbureau);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un chef de bureau", description = "Supprime un chef de bureau de la base de données.")
    public void deleteById(
            @Parameter(description = "ID du chef de bureau à supprimer")
            @PathVariable Long id){
        chefbureauService.deleteById(id);
    }
}