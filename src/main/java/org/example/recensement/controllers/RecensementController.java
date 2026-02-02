package org.example.recensement.controllers;

import org.example.recensement.entities.Rapport;
import org.example.recensement.entities.Recensement;
import org.example.recensement.services.RapportService;
import org.example.recensement.services.RecensementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur les recensements.
 */
@RestController
@RequestMapping("/api/recensement")
public class RecensementController {

    private final RecensementService recensementService;

    @Autowired
    public RecensementController(RecensementService recensementService) {
        this.recensementService = recensementService;
    }

    /**
     * Récupérer tous les recensements
     */
    @GetMapping
    public List<Recensement> findAll() {
        return recensementService.findAll();
    }

    /**
     * Récupérer un recensement par son ID
     */
    @GetMapping("/{id}")
    public Optional<Recensement> findById(@PathVariable long id){

        return recensementService.findById(id);
    }

    /**
     * Créer un nouveau recensement
     */
    @PostMapping
    public Recensement save(@RequestBody Recensement recensement) {
        return recensementService.save(recensement);
    }

    /**
     * Mettre à jour un recensement existant
     */
    @PutMapping("/{id}")
    public Recensement update(@RequestBody Recensement recensement){

        return recensementService.save(recensement);
    }

    /**
     * Supprimer un recensement par son ID
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        recensementService.deleteById(id);
    }
}
