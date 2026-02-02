package org.example.recensement.repositories;

import org.example.recensement.entities.Chefbureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefbureauRepository extends JpaRepository<Chefbureau,Long> {
}
