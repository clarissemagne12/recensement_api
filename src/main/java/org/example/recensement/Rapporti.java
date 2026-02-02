package org.example.recensement;

import org.example.recensement.entities.Rapport;

import java.util.List;
import java.util.Optional;

public interface Rapporti {
    List<Rapport> findAll();
    Optional<Rapport> findById(Long id);
    Rapport save(Rapport rapport);
    void deleteById(Long id);
    Rapport update(Rapport rapport);
}
