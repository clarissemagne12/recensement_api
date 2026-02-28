package org.example.recensement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.recensement.entities.Rapport;
import org.example.recensement.services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rapport")
@Tag(name = "Gestion des Rapports", description = "API pour la manipulation des rapports de recensement")
public class RapportController {

    private final RapportService rapportService;

    @Autowired
    public RapportController(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    @GetMapping
    @Operation(summary = "Liste des rapports", description = "Récupère l'intégralité des rapports disponibles.")
    public List<Rapport> findAll() {
        return rapportService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Chercher un rapport", description = "Fournit les détails d'un rapport via son identifiant unique.")
    public Optional<Rapport> findById(
            @Parameter(description = "ID unique du rapport", example = "10")
            @PathVariable long id){
        return rapportService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un rapport", description = "Ajoute un nouveau rapport dans le système.")
    public Rapport save(@RequestBody Rapport rapport){
        return rapportService.save(rapport);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un rapport", description = "Met à jour les informations d'un rapport existant.")
    public Rapport update(
            @Parameter(description = "ID du rapport à modifier")
            @PathVariable long id,
            @RequestBody Rapport rapport){
        // Il est conseillé de s'assurer que l'ID de l'URL est bien appliqué à l'objet
        return rapportService.save(rapport);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un rapport", description = "Efface définitivement un rapport de la base de données.")
    public void deleteById(
            @Parameter(description = "ID du rapport à supprimer")
            @PathVariable Long id){
        rapportService.deleteById(id);
    }
}