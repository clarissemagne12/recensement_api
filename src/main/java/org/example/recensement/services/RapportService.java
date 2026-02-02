package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Rapporti;
import org.example.recensement.entities.Rapport;
import org.example.recensement.repositories.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RapportService implements Rapporti {

    /** annotation d'injecter un objet dans une autre classe
     * sans instanciation manuelle avec new
     */
    @Autowired

    /** Repository injecté pour accéder aux données des rapports */
    private final RapportRepository rapportRepository;

    /**
     * Constructeur du service rapport.
     *
     * @param rapportRepository le repository de l'entité
     */

    public RapportService(RapportRepository rapportRepository) {

        this.rapportRepository = rapportRepository;
    }


    @Override
    /**Récupère toutes
     * les rapports enregistrés.
     * @return liste de tous les rapports
     */
    public List<Rapport> findAll(){
        return rapportRepository.findAll();
    }
    /**Cette annotation indique que la méthode redéfinit une
     * méthode déclarée dans une interface
     * ou une classe parente
     */
    @Override

    /**
     * Méthode publique qui peut être appelée
     * depuis n’importe quelle classe (comme ton contrôleur).
     *
     * Elle prend un identifiant id de type Long
     * pour rechercher un rapport.
     */
    public Optional<Rapport> findById(Long id){
        return rapportRepository.findById(id);
    }


    /**Cette annotation indique que la méthode redéfinit une
     * méthode déclarée dans une interface
     * ou une classe parente
     */
    @Override

    /**
     * Enregistre un nouveau rapports dans la base de données.
     *
     * @param rapport l'objet rapport à enregistrer
     * @return un rapport enregistré avec son ID généré
     */

    public Rapport save(Rapport rapport){

        return rapportRepository.save(rapport);
    }

    /**
     * Met à jour d'un rapport existant.
     *
     * @param rapport le rapport à mettre à jour
     * @return le rapport mis à jour
     */
    @Override
    public Rapport update(Rapport rapport){

        return rapportRepository.save(rapport);
    }


    /**Cette annotation indique que la méthode redéfinit une
     * méthode déclarée dans une interface
     * ou une classe parente
     */

    @Override
    /**
     * Cette méthode permet de supprimer un enregistrement
     * de la base de données à partir de son identifiant..
     *
     * @param id l'objet rapport à supprimer
     */
    public void deleteById(Long id){
        rapportRepository.deleteById(id);
    }
}
