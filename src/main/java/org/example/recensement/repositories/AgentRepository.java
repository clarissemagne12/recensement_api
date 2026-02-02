package org.example.recensement.repositories;

import org.example.recensement.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository <Agent, Long>{

}
