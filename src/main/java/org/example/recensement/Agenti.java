package org.example.recensement;

import org.example.recensement.entities.Agent;
import org.example.recensement.entities.Chefbureau;

import java.util.List;
import java.util.Optional;

public interface Agenti {
    List<Agent> findAll();
    Optional<Agent> findById(Long id);
    Agent save(Agent agent);
    void deleteById(Long id);
    Agent update(Agent agent);
}
