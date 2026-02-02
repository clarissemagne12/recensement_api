package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Recensementi;
import org.example.recensement.entities.Recensement;
import org.example.recensement.repositories.RecensementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class RecensementService implements Recensementi {
    @Autowired

    /** Repository injecté pour accéder aux données des cours */
    private final RecensementRepository recensementRepository;

    /**
     * Constructeur du service recensement.
     *
     * @param recensementRepository le repository de l'entité
     */

    public RecensementService(RecensementRepository recensementRepository) {

        this.recensementRepository = recensementRepository;
    }

    /**
     * Récupère tous les recensement enregistrés.
     *
     * @return liste de tous les recensement
     */
    @Override
    public List<Recensement> findAll(){
        return recensementRepository.findAll();
    }
    @Override

    /**
     * Méthode publique qui peut être appelée
     * depuis n’importe quelle classe (comme ton contrôleur).
     *
     * Elle prend un identifiant id de type Long
     * pour rechercher un recensement.
     */
     public Optional<Recensement> findById(Long id){
        return recensementRepository.findById(id);
    }

    /**
     * Enregistre un nouveau recensement dans la base de données.
     *
     * @param recensement l'objet recensement à enregistrer
     * @return le recensement enregistré avec son ID généré
     */
    @Override
    public Recensement save(Recensement recensement){

        return recensementRepository.save(recensement);
    }

    /**
     * Met à jour un cours existant.
     *
     * @param recensement le cours à mettre à jour
     * @return le cours mis à jour
     */
    @Override
    public Recensement update(Recensement recensement){

        return recensementRepository.save(recensement);
    }


    @Override
    /**
     * Cette méthode permet de supprimer un enregistrement
     * de la base de données à partir de son identifiant.
     *
     * @param id l'objet rapport à supprimer
     *
     */
    public void deleteById(Long id){
        recensementRepository.deleteById(id);
    }
}
