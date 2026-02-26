package org.example.recensement.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Role", description = "Gestion des rôles")
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

    @Operation(
            summary = "Récupérer tous les rôle par ID",
            description = "Cette méthode permet d'afficher la liste des rôles."
    )
    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    /**
     * Récupérer un rôle par son ID
     */
    @Operation(
            summary = "Récupérer un rôle par ID",
            description = "Cette méthode permet de récupérer les informations d’un rôle spécifique à partir de son identifiant."
    )

    @GetMapping("/{id}")
    public Optional<Role> findById(
            @Parameter(
                    description = "Identifiant unique du rôle",
                    example = "1",
                    required = true
            )
            @PathVariable long id
    ) {
        return roleService.findById(id);
    }

    /**
     * Créer un nouveau rôle
     */
    @Operation(
            summary = "Créer un nouveau rôle",
            description = "Cette méthode permet de récupérer les informations d’un rôle spécifique à partir de son identifiant."
    )
    @PostMapping
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }

    /**
     * Mettre à jour un rôle existant
     */
    @Operation(
            summary = "Mettre à jour un rôle existant",
            description = "Cette méthode permet de mettre à jour un rôle."

    )
    @PutMapping("/{id}")
    public Role update(
            @RequestBody Role role,
            @Parameter(
                    description = "Identifiant unique du rôle",

                    required = true
            )
            @PathVariable Long id
    ) {

        return roleService.save(role);
    }    /**
     * Supprimer un rôle par son ID
     */
    @Operation(
            summary = "Supprimer un rôle par son ID",
            description = "Cette méthode permet defaire la suppression d'un rôle."
    )
    @DeleteMapping("/{id}")
    public void deleteById(
            @Parameter(
                    description = "Identifiant unique du rôle",
                    required = true
            )
            @PathVariable Long id
    ) {
        roleService.deleteById(id);
    }
}
