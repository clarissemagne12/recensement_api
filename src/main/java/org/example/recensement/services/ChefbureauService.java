package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Chefbureaui;
import org.example.recensement.entities.Agent;
import org.example.recensement.entities.Chefbureau;
import org.example.recensement.repositories.ChefbureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChefbureauService implements Chefbureaui {


    @Autowired

    /** Repository injecté pour accéder aux données des chefbureau */
    private final ChefbureauRepository chefbureauRepository;

    /**
     * Constructeur du service chefbureau.
     *
     * @param chefbureauRepository le repository de l'entité
     */

    public ChefbureauService(ChefbureauRepository chefbureauRepository) {

        this.chefbureauRepository = chefbureauRepository;
    }

    /**
     * Récupère tous les chefbureau enregistrés.
     *
     * @return liste de tous les chefbureau
     */
    @Override
    /**
     * Méthode publique qui peut être appelée
     * depuis n’importe quelle classe (comme ton contrôleur).
     *
     * Elle prend un identifiant id de type Long
     * pour rechercher un Chefbureau.
     */
    public List<Chefbureau> findAll(){
        return chefbureauRepository.findAll();
    }
    @Override
    public Optional<Chefbureau> findById(Long id){
        return chefbureauRepository.findById(id);
    }

    /**
     * Enregistre un nouveau chefbureau dans la base de données.
     *
     * @param chefbureau l'objet agent à enregistrer
     * @return un chefbureau enregistré avec son ID généré
     */
    @Override
    public Chefbureau save(Chefbureau chefbureau){

        return chefbureauRepository.save(chefbureau);
    }

    /**
     * Met à jour un chefbureau existant.
     *
     * @param chefbureau le chefbureau à mettre à jour
     * @return le chefbureau mis à jour
     */
    @Override
    public Chefbureau update(Chefbureau chefbureau){

        return chefbureauRepository.save(chefbureau);
    }

    /**
     * Cette méthode permet de supprimer un enregistrement
     * de la base de données à partir de son identifiant.
     *
     * @param id l'objet rapport à supprimer
     *
     */
    @Override
    public void deleteById(Long id){
        chefbureauRepository.deleteById(id);
    }
}




