package org.example.recensement.repositories;

import org.example.recensement.entities.Recensement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensementRepository extends JpaRepository<Recensement,Long> {
}
