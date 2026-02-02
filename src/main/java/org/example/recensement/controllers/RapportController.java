package org.example.recensement.controllers;

import org.example.recensement.entities.Personne;
import org.example.recensement.entities.Rapport;
import org.example.recensement.services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur les rapports.
 */
@RestController
@RequestMapping("/api/rapport")
public class RapportController {

    private final RapportService rapportService;

    @Autowired
    public RapportController(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    /**
     * Récupérer tous les rapports
     */
    @GetMapping
    public List<Rapport> findAll() {
        return rapportService.findAll();
    }

    /**
     * Récupérer un rapport par son ID
     */
    @GetMapping("/{id}")
    public Optional<Rapport> findById(@PathVariable long id){

        return rapportService.findById(id);
    }

    /**
     * Créer un nouveau rapport
     */
    @PostMapping
    public Rapport save(@RequestBody Rapport rapport){

        return rapportService.save(rapport);
    }

    /**
     * Mettre à jour un rapport existant
     */
    @PutMapping("/{id}")
    public Rapport update(@RequestBody Rapport rapport){

        return rapportService.save(rapport);
    }

    /**
     * Supprimer un rapport par son ID
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        rapportService.deleteById(id);
    }
}
