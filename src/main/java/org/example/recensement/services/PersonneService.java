package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Personnei;
import org.example.recensement.entities.Chefbureau;
import org.example.recensement.entities.Personne;
import org.example.recensement.entities.Recensement;
import org.example.recensement.repositories.ChefbureauRepository;
import org.example.recensement.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonneService implements Personnei {

    /** Repository injecté pour accéder aux données des rapports
     * ou d'injecter un objet dans une autre classe
     * sans instanciation manuelle avec new
     */
    @Autowired

    /** Repository injecté pour accéder aux données des personnes */
    private final PersonneRepository personneRepository;

    /**
     * Constructeur du service personne.
     *
     * @param personneRepository le repository de l'entité
     */

    public PersonneService(PersonneRepository personneRepository) {

        this.personneRepository = personneRepository;
    }

    /**
     * Récupère tous les personnes enregistrés.
     *
     * @return liste de tous les personnes
     */
    @Override
    public List<Personne> findAll(){
        return personneRepository.findAll();
    }
    @Override

    /**
     * Méthode publique qui peut être appelée
     * depuis n’importe quelle classe (comme ton contrôleur).
     *
     * Elle prend un identifiant id de type Long
     * pour rechercher une personne.
     */
    public Optional<Personne> findById(Long id){
        return personneRepository.findById(id);
    }

    /**
     * Enregistre un nouveau personne dans la base de données.
     *
     * @param personne l'objet agent à enregistrer
     * @return un personne enregistré avec son ID généré
     */
    @Override
    public Personne save(Personne personne){

        return personneRepository.save(personne);
    }

    /**
     * Met à jour un personne existant.
     *
     * @param personne le personne à mettre à jour
     * @return le personne mis à jour
     */
    @Override
    public Personne update(Personne personne){

        return personneRepository.save(personne);
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
        personneRepository.deleteById(id);
    }
}
