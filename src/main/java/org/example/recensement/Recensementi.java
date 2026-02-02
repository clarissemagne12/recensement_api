package org.example.recensement;

import org.example.recensement.entities.Recensement;

import java.util.List;
import java.util.Optional;

public interface Recensementi {
    List<Recensement> findAll();
    Optional<Recensement> findById(Long id);
    Recensement save(Recensement recensement);
    void deleteById(Long id);
    Recensement update(Recensement recensement);
}
