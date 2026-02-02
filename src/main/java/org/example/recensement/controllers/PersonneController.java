package org.example.recensement.controllers;

import org.example.recensement.entities.Chefbureau;
import org.example.recensement.entities.Personne;
import org.example.recensement.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personne")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    /**
     * Récupère la liste de toutes les personnes.
     */
    @GetMapping
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    /**
     * Récupère une personne par son ID.
     */
    @GetMapping("/{id}")
    public Optional<Personne> findById(@PathVariable long id){

        return personneService.findById(id);
    }

    /**
     * Crée une nouvelle personne.
     */
    @PostMapping
    public Personne save(@RequestBody Personne personne){

        return personneService.save(personne);
    }

    /**
     * Met à jour une personne existante.
     */
    @PutMapping("/{id}")
    public Personne update(@RequestBody Personne personne){

        return personneService.save(personne);
    }

    /**
     * Supprime une personne par son ID.
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        personneService.deleteById(id);
    }
}
