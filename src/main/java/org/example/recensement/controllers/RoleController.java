package org.example.recensement.controllers;

import org.example.recensement.entities.Recensement;
import org.example.recensement.entities.Role;
import org.example.recensement.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour gérer les rôles.
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Récupérer tous les rôles
     */
    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    /**
     * Récupérer un rôle par son ID
     */
    @GetMapping("/{id}")
    public Optional<Role> findById(@PathVariable long id){

        return roleService.findById(id);
    }

    /**
     * Créer un nouveau rôle
     */
    @PostMapping
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }

    /**
     * Mettre à jour un rôle existant
     */
    @PutMapping("/{id}")
    public Role update(@RequestBody Role role){

        return roleService.save(role);
    }

    /**
     * Supprimer un rôle par son ID
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        roleService.deleteById(id);
    }
}
