package org.example.recensement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.example.recensement.entities.Role;
import org.example.recensement.services.RoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Role", description = "Gestion des rôles")
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private static final Logger logger =
            LoggerFactory.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Récupérer tous les rôles
     */
    @Operation(
            summary = "Récupérer tous les rôles",
            description = "Afficher la liste complète des rôles."
    )
    @GetMapping
    public List<Role> findAll() {
        logger.info("Requête GET - récupération de tous les rôles");
        List<Role> list = roleService.findAll();

        if (list.isEmpty()) {
            logger.warn("Aucun rôle trouvé");
        }

        logger.debug("Nombre de rôles récupérés : {}", list.size());
        return list;
    }

    /**
     * Récupérer un rôle par ID
     */
    @Operation(
            summary = "Récupérer un rôle par ID",
            description = "Retourne un rôle spécifique selon son identifiant."
    )
    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(
            @Parameter(description = "ID du rôle", example = "1", required = true)
            @PathVariable Long id) {

        logger.info("Requête GET - récupération du rôle id={}", id);

        Optional<Role> role = roleService.findById(id);

        return role.map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("Rôle non trouvé id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    /**
     * Créer un rôle
     */
    @Operation(
            summary = "Créer un rôle",
            description = "Permet d'ajouter un nouveau rôle."
    )
    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role) {
        logger.info("Requête POST - création d'un rôle");

        Role saved = roleService.save(role);

        logger.info("Rôle créé avec succès id={}", saved.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Mettre à jour un rôle
     */
    @Operation(
            summary = "Mettre à jour un rôle",
            description = "Met à jour un rôle existant."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Role> update(
            @PathVariable Long id,
            @RequestBody Role role) {

        logger.info("Requête PUT - mise à jour du rôle id={}", id);

        return roleService.findById(id)
                .map(existing -> {
                    existing.setLibelle(role.getLibelle());
                    Role updated = roleService.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> {
                    logger.warn("Rôle non trouvé id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    /**
     * Supprimer un rôle
     */
    @Operation(
            summary = "Supprimer un rôle",
            description = "Supprime un rôle selon son identifiant."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @Parameter(description = "ID du rôle", required = true)
            @PathVariable Long id) {

        logger.info("Requête DELETE - suppression du rôle id={}", id);

        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}