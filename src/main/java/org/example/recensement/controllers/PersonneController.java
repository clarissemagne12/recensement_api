package org.example.recensement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.recensement.entities.Personne;
import org.example.recensement.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personne")
@Tag(name = "Gestion des Personnes", description = "API pour gérer les informations des personnes recensées")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    @Operation(summary = "Obtenir toutes les personnes", description = "Retourne la liste complète des personnes enregistrées.")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Rechercher une personne", description = "Récupère les détails d'une personne via son ID.")
    public Optional<Personne> findById(
            @Parameter(description = "Identifiant unique de la personne", example = "1")
            @PathVariable long id){
        return personneService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter une personne", description = "Enregistre une nouvelle personne dans la base de données.")
    public Personne save(@RequestBody Personne personne){
        return personneService.save(personne);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une personne", description = "Met à jour les informations d'une personne existante.")
    public Personne update(
            @Parameter(description = "ID de la personne à modifier")
            @PathVariable long id,
            @RequestBody Personne personne){
        // Note: Assurez-vous que l'objet personne utilise bien l'id du chemin (path)
        return personneService.save(personne);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une personne", description = "Supprime définitivement une personne du système.")
    public void deleteById(
            @Parameter(description = "ID de la personne à supprimer")
            @PathVariable Long id){
        personneService.deleteById(id);
    }
}