package org.example.recensement;

import org.example.recensement.entities.Personne;
import org.example.recensement.entities.Recensement;

import java.util.List;
import java.util.Optional;

public interface Personnei {
    List<Personne> findAll();
    Optional<Personne> findById(Long id);
    Personne save(Personne personne);
    void deleteById(Long id);
    Personne update(Personne personne);
}
