package org.example.recensement.controllers;

<<<<<<< HEAD
=======

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.example.recensement.entities.Recensement;
>>>>>>> d6aa50cdfb76f4a5a289f40c6dc200d12f99d362
import org.example.recensement.entities.Role;
import org.example.recensement.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Contrôleur REST pour gérer les rôles.
 */
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Role", description = "Gestion des rôles")
@RestController
@RequestMapping("/api/role")
public class RoleController {

<<<<<<< HEAD
    /**
     *
     *recommandé pour éviter de recréer le logger à chaque instance.
     */
    private static final Logger logger =
            /**
             *
             *associe le logger à la classe.
             */
            LoggerFactory.getLogger(RoleController.class);
=======
>>>>>>> d6aa50cdfb76f4a5a289f40c6dc200d12f99d362

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
        logger.info("Requête GET - récupération de tous les rôles");
        List<Role> listrol= roleService.findAll();

        if (listrol.isEmpty()) {
            logger.warn("Aucun rôle trouvé dans la base de données");
            //return ResponseEntity.noContent().build();
        }
         logger.debug("Nombre de rôles récupérés : {}", listrol.size());
        return listrol;
    }

    /**
     * Récupérer un rôle par son ID
     */
<<<<<<< HEAD
    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        logger.info("Requête GET - récupération du rôle avec id={}", id);

        return roleService.findById(id)
                .map(role -> ResponseEntity.ok(role)) // <-- ici on renvoie ResponseEntity 200
                .orElseGet(() -> {
                    logger.warn("Rôle non trouvé id={}", id);

                    return ResponseEntity.notFound().build(); // <-- 404 si pas trouvé
                });
=======
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
>>>>>>> d6aa50cdfb76f4a5a289f40c6dc200d12f99d362
    }
//    public Optional<Role> findById(@PathVariable long id){
//        logger.info("Requête GET - récupération du rôle avec id={}", id);
//        Optional<Role> list;
//        return roleService.findById(id)
//                .map(roleService::ok)
//                .orElseGet(() -> {
//                            logger.warn("Rôle non trouvé id={}", id);
//                    return new ArrayList<>();
//                });
//
//    }

    /**
     * Créer un nouveau rôle
     */
    @Operation(
            summary = "Créer un nouveau rôle",
            description = "Cette méthode permet de récupérer les informations d’un rôle spécifique à partir de son identifiant."
    )
    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role) {

        try{
        logger.info("Requête POST - création d'un rôle");
        Role saved = roleService.save(role);

        logger.info("Rôle créé avec succès id={}", saved.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch(Exception e){
            logger.error("Erreur lors de la sauvegarde de l'agent", e);
            throw e; // relancer l'exception si nécessaire
        }
    }

    /**
     * Mettre à jour un rôle existant
     */
    @Operation(
            summary = "Mettre à jour un rôle existant",
            description = "Cette méthode permet de mettre à jour un rôle."

    )
    @PutMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role role){
        logger.info("Requête PUT - mise à jour du rôle id={}", role.getId());
        return roleService.findById(id)
                .map(existingRole -> {
                    existingRole.setLibelle(role.getLibelle()); // adapter selon tes champs
                    Role updated = roleService.save(existingRole);
                    return ResponseEntity.ok(updated); // HTTP 200
                })
                .orElseGet(() -> {
                    logger.warn("Impossible de mettre à jour, rôle non trouvé id={}", id);
                    return ResponseEntity.notFound().build(); // HTTP 404
                });
    }

    /**
=======
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
>>>>>>> d6aa50cdfb76f4a5a289f40c6dc200d12f99d362
     * Supprimer un rôle par son ID
     */
    @Operation(
            summary = "Supprimer un rôle par son ID",
            description = "Cette méthode permet defaire la suppression d'un rôle."
    )
    @DeleteMapping("/{id}")
<<<<<<< HEAD
    public void deleteById(@PathVariable Long id){
        logger.info("Requête DELETE - suppression du rôle id={}", id);

=======
    public void deleteById(
            @Parameter(
                    description = "Identifiant unique du rôle",
                    required = true
            )
            @PathVariable Long id
    ) {
>>>>>>> d6aa50cdfb76f4a5a289f40c6dc200d12f99d362
        roleService.deleteById(id);
    }
}
