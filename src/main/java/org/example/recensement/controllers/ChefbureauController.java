package org.example.recensement.controllers;

import org.example.recensement.entities.Agent;
import org.example.recensement.entities.Chefbureau;
import org.example.recensement.services.ChefbureauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour la gestion des Chefbureau.
 *
 * Expose les endpoints CRUD pour :
 * - créer un chefbureau
 * - récupérer tous les chefbureau
 * - récupérer un chefbureau par ID
 * - modifier un chefbureau
 * - supprimer un chefbureau
 *
 * @author Clarisse
 * @version 1.0
 */
@RestController
@RequestMapping("/api/chefbureau")
public class ChefbureauController {

    private final ChefbureauService chefbureauService;

    @Autowired
    public ChefbureauController(ChefbureauService chefbureauService) {
        this.chefbureauService = chefbureauService;
    }

    /**
     * Récupérer tous les chefbureau.
     */
    @GetMapping
    public List<Chefbureau> findAll() {
        return chefbureauService.findAll();
    }

    /**
     * Récupérer un chefbureau par son identifiant.
     */
    @GetMapping("/{id}")
    public Optional<Chefbureau> findById(@PathVariable long id){

        return chefbureauService.findById(id);
    }

    /**
     * Créer un nouveau chefbureau.
     */
    @PostMapping
    public Chefbureau save(@RequestBody Chefbureau chefbureau){

        return chefbureauService.save(chefbureau);
    }

    /**
     * Mettre à jour un agent existant.
     *
     * @param @id identifiant de l'agent
     * @param chefbureau agent modifié
     * @return chefbureau mis à jour ou 404
     */
    @PutMapping("/{id}")
    public Chefbureau update(@RequestBody Chefbureau chefbureau){

        return chefbureauService.save(chefbureau);
    }

    /**
     * Supprimer un chefbureau par son identifiant.
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        chefbureauService.deleteById(id);
    }
}

