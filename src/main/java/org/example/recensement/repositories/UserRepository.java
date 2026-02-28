package org.example.recensement.repositories;

import org.example.recensement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
    // Spring Data JPA générera automatiquement la requête SQL
    Optional<User> findByUsername(String username);
}
