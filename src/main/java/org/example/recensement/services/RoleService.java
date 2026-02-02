package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Rolei;
import org.example.recensement.entities.Rapport;
import org.example.recensement.entities.Role;
import org.example.recensement.repositories.RapportRepository;
import org.example.recensement.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class RoleService implements Rolei {


    /** annotation d'injecter un objet dans une autre classe
     * sans instanciation manuelle avec new
     */
    @Autowired

    /** Repository injecté pour accéder aux données des roles */
    private final RoleRepository roleRepository;

    /**
     * Constructeur du service Role.
     *
     * @param roleRepository le repository de l'entité
     */

    public RoleService(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }


    @Override
    /**Récupère toutes
     * les rapports enregistrés.
     * @return liste de tous les rapports
     */
    public List<Role> findAll(){
        return roleRepository.findAll();
    }
    /**Cette annotation indique que la méthode redéfinit une
     * méthode déclarée dans une interface
     * ou une classe parente
     */
    @Override

    /**rechercher un rapport dans la base de données
     * à partir de son identifiant.
     */
    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }

    @Override

    /**
     * Enregistre un nouveau role dans la base de données.
     *
     * @param role l'objet roel à enregistrer
     * @return un role enregistré avec son ID généré
     */

    public Role save(Role role){

        return roleRepository.save(role);
    }

    /**
     * Met à jour d'un role existant.
     *
     * @param role le role à mettre à jour
     * @return le role mis à jour
     */
    @Override
    public Role update(Role role){

        return roleRepository.save(role);
    }




    @Override
    /**
     * Cette méthode permet de supprimer un enregistrement
     * de la base de données à partir de son identifiant..
     *
     * @param id l'objet rapport à supprimer
     */
    public void deleteById(Long id){
        roleRepository.deleteById(id);
    }
}
